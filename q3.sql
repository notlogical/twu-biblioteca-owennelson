#!/usr/bin/sqlite3

SELECT title
FROM book
WHERE book.title NOT IN (
	SELECT book.title 
	FROM checkout_item, book
	WHERE book.id = checkout_item.book_id
);
