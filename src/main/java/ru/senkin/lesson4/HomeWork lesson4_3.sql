--список фильмов, для каждого — с указанием общего числа посетителей за все время, 
--среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли). 
--Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;

CREATE TEMP TABLE client_movie ON COMMIT DROP
AS 
SELECT 
	m1.id, m1.movie_name, COUNT(t1.id) as "clients_count"
FROM movies m1 
LEFT JOIN sessions s1 ON s1.id_movie = m1.id
LEFT JOIN tickets t1 ON t1.id_session = s1.id
GROUP BY m1.id, m1.movie_name
ORDER BY 1 desc;
--select * from client_movie;

CREATE TEMP TABLE client_session ON COMMIT DROP
AS 
SELECT 
	m1.id, m1.movie_name, 
	CASE WHEN COUNT(s1.id) = 0 THEN 0 ELSE cm1.clients_count::FLOAT / COUNT(s1.id) END AS "sessions_count"
FROM movies m1 
LEFT JOIN sessions s1 ON s1.id_movie = m1.id
LEFT JOIN client_movie cm1 ON cm1.id = m1.id
GROUP BY m1.id, m1.movie_name, cm1.clients_count
ORDER BY m1.id;
--select * from client_session;

CREATE TEMP TABLE movie_money ON COMMIT DROP
AS 
SELECT 
	m1.id, m1.movie_name, SUM(s1.ticket_price) as "movie_money"
FROM movies m1 
INNER JOIN sessions s1 ON s1.id_movie = m1.id
INNER JOIN tickets t1 ON t1.id_session = s1.id
GROUP BY m1.id, m1.movie_name
ORDER BY m1.id;
--select * from movie_money;

CREATE TEMP TABLE result_table ON COMMIT DROP
AS 
SELECT 
	cm.movie_name AS "Название фильма",
	cm.clients_count AS "Общее количество зрителей",
	cs.sessions_count AS "Cреднего число зрителей за сеанс",
	CASE WHEN mm.movie_money isnull THEN '' ELSE mm.movie_money END AS "Общая сумма сборов"
FROM client_movie cm
	LEFT JOIN client_session cs ON cs.id = cm.id
	LEFT JOIN movie_money mm ON mm.id = cm.id
ORDER BY cm.id;

SELECT *
FROM result_table
UNION
SELECT 
	' ИТОГО',
	SUM("Общее количество зрителей"),
	AVG("Cреднего число зрителей за сеанс"),	
	SUM("Общая сумма сборов")
FROM result_table 
ORDER BY 1 desc;


