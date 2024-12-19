-- CreateTable
CREATE TABLE categories (
    id UUID NOT NULL PRIMARY KEY,
    name TEXT NOT NULL
);

-- CreateTable
CREATE TABLE markets (
    id UUID NOT NULL PRIMARY KEY,
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    coupons INTEGER NOT NULL,
    latitude REAL NOT NULL,
    longitude REAL NOT NULL,
    address TEXT NOT NULL,
    phone TEXT NOT NULL,
    cover TEXT NOT NULL,
    category_id UUID NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

-- CreateTable
CREATE TABLE rules (
    id UUID NOT NULL PRIMARY KEY,
    description TEXT NOT NULL,
    market_id UUID NOT NULL,
    FOREIGN KEY (market_id) REFERENCES markets(id)
);

