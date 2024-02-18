CREATE TABLE emails (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    ownerRef TEXT NOT NULL,
    emailFrom TEXT NOT NULL,
    emailTo TEXT NOT NULL,
    subject TEXT NOT NULL,
    content TEXT NOT NULL,
    sendDate DATE NOT NULL,
    status TEXT NOT NULL
);