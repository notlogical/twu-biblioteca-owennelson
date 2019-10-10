#!/usr/bin/sqlite3

SELECT member.name 
FROM member, book, checkout_item 
WHERE book.title = "The Hobbit"
AND checkout_item.book_id = book.id
AND member.id = checkout_item.member_id;
