#!/usr/bin/sqlite3

DELETE FROM book
WHERE id=11;

DELETE FROM member
WHERE name = "Owen Nelson";

DELETE FROM checkout_item
WHERE member_id = 43;
