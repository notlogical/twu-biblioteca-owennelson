#!/usr/bin/sqlite3

SELECT title
FROM book
WHERE book.title NOT IN (
	SELECT book.title 
	FROM checkout_item, book
	WHERE book.id = checkout_item.book_id
);

SELECT title
FROM movie
WHERE movie.title NOT IN (
	SELECT movie.title
	FROM checkout_item, movie
	WHERE movie.id = checkout_item.movie_id
);
