INSERT INTO users (id, username, password, expired, locked, credentials_expired, disabled)
VALUES (1, 'admin', '$2a$10$xHeWF1.4T7HEBcq4qcvE9emZSdCVvd1lLoeCyvZzNH/0rhTlqtQia', false, false, false, false);
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);

INSERT INTO users (id, username, password, expired, locked, credentials_expired, disabled)
VALUES (2, 'user', '$2a$10$b5i/au6zgPVC0Py0dx/AxOZrlp4E0SpdFKbBtsO9.VcLZpEwDs006', false, false, false, false);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
