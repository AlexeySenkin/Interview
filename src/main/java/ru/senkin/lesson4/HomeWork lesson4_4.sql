--число посетителей и кассовые сборы, сгруппированные 
--по времени начала фильма: с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 
--(сколько посетителей пришло с 9 до 15 часов и т.д.).

CREATE TEMP TABLE client_movie_time ON COMMIT DROP
AS 
SELECT 
	m1.id, m1.movie_name, 
	CASE 
		WHEN EXTRACT(hour FROM s1.start_time) BETWEEN 0 AND 9 THEN 'до 9'
		WHEN EXTRACT(hour FROM s1.start_time) BETWEEN 9 AND 15 THEN 'с 9 до 15' 
		WHEN EXTRACT(hour FROM s1.start_time) BETWEEN 15 AND 18 THEN 'с 15 до 18' 
		WHEN EXTRACT(hour FROM s1.start_time) BETWEEN 18 AND 21 THEN 'с 18 до 21' 
		WHEN EXTRACT(hour FROM s1.start_time) BETWEEN 21 AND 24 THEN 'с 21 до 00:00'
		ELSE 'сеансы отсутсвуют' END AS "start_time", 
	COUNT(t1.id) as "clients_count"
FROM movies m1 
LEFT JOIN sessions s1 ON s1.id_movie = m1.id
LEFT JOIN tickets t1 ON t1.id_session = s1.id
GROUP BY m1.id, m1.movie_name, 3
ORDER BY 2,3 desc;
--select * from client_movie_time;

CREATE TEMP TABLE movie_money_time ON COMMIT DROP
AS 
SELECT 
	m1.id, m1.movie_name, 
	CASE 
		WHEN EXTRACT(hour FROM s1.start_time) BETWEEN 0 AND 9 THEN 'до 9'
		WHEN EXTRACT(hour FROM s1.start_time) BETWEEN 9 AND 15 THEN 'с 9 до 15' 
		WHEN EXTRACT(hour FROM s1.start_time) BETWEEN 15 AND 18 THEN 'с 15 до 18' 
		WHEN EXTRACT(hour FROM s1.start_time) BETWEEN 18 AND 21 THEN 'с 18 до 21' 
		WHEN EXTRACT(hour FROM s1.start_time) BETWEEN 21 AND 24 THEN 'с 21 до 00:00'
		ELSE 'сеансы отсутсвуют' END AS "start_time", 
	SUM(s1.ticket_price) as "movie_money"
FROM movies m1 
INNER JOIN sessions s1 ON s1.id_movie = m1.id
INNER JOIN tickets t1 ON t1.id_session = s1.id
GROUP BY m1.id, m1.movie_name, 3
ORDER BY m1.id;
--select * from movie_money_time;


select
	cmt.movie_name AS "Название фильма",
	cmt.start_time AS "Время начала фильма",
	cmt.clients_count AS "Число посетителей",
	CASE WHEN mmt.movie_money isnull THEN '' ELSE mmt.movie_money END AS "Кассовые сборы"
from client_movie_time cmt 
LEFT JOIN movie_money_time mmt 
	ON mmt.id=cmt.id AND mmt.start_time=cmt.start_time
ORDER BY 1,2



