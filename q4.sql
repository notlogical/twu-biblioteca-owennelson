#!/usr/bin/sqlite3

INSERT INTO book (id, title)
VALUES (11, "The Pragmatic Programmer");

INSERT INTO member (id, name)
VALUES (43, "Owen Nelson");

INSERT INTO checkout_item (member_id, book_id)
VALUES (43, 11);

SELECT member.name
FROM member, book, checkout_item
WHERE book.title = "The Pragmatic Programmer"
AND checkout_item.book_id = book.id
AND member.id = checkout_item.member_id;
