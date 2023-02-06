--ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени. 
--Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;

select 
	m1.movie_name AS "Фильм 1", s1.start_time AS "время начала", 
	m1.movie_duration AS "Длительность", 
 	m2.movie_name AS "Фильм 2", s2.start_time AS "время начала", 
	m2.movie_duration AS "Длительность"
from sessions s1 
inner join movies m1 ON m1.id = s1.id_movie
inner join sessions s2 ON s2.id <> s1.id AND 
	s2.id_movie_theater = s1.id_movie_theater AND 
	s2.start_time > s1.start_time AND 
	s2.start_time <= s1.start_time + INTERVAL '1 minute' * m1.movie_duration 
inner join movies m2 ON m2.id = s2.id_movie
order by s1.start_time;

