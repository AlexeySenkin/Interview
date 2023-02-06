--перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва. 
--Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;

CREATE TEMP TABLE sessions_on_day ON COMMIT DROP
AS 
select 
	s1.*,
	DENSE_RANK() OVER (
    ORDER BY s1.id_movie_theater, 
			EXTRACT(YEAR FROM s1.start_time), 
			EXTRACT(MONTH FROM s1.start_time), 
			EXTRACT(DAY FROM s1.start_time)
	) as "sort_theater_day",
	ROW_NUMBER () OVER ( 
		PARTITION BY s1.id_movie_theater, 
			EXTRACT(YEAR FROM s1.start_time), 
			EXTRACT(MONTH FROM s1.start_time), 
			EXTRACT(DAY FROM s1.start_time)
          	ORDER BY s1.start_time
        ) as "sort_theater_day_movie"
from sessions s1;

CREATE INDEX i1 ON sessions_on_day (id);


select 
	m1.movie_name AS "Фильм 1", s1.start_time AS "время начала", 
	m1.movie_duration AS "Длительность", s2.start_time AS "время начала второго фильма", 
	s2.start_time - s1.start_time - INTERVAL '1 minute' * m1.movie_duration AS "длительность перерыва"	
from sessions_on_day s1 
inner join movies m1 ON m1.id = s1.id_movie
inner join sessions_on_day s2 ON s2.id <> s1.id AND 
	s2.sort_theater_day = s1.sort_theater_day AND 
	s2.sort_theater_day_movie = s1.sort_theater_day_movie + 1 AND 
	s2.start_time >= s1.start_time  + INTERVAL '1 minute' * m1.movie_duration + INTERVAL '30 minute'
inner join movies m2 ON m2.id = s2.id_movie
order by 5;


