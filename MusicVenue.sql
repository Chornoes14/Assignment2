--
-- File generated with SQLiteStudio v3.4.15 on Fri Feb 7 15:49:59 2025
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: MANAGERS
CREATE TABLE IF NOT EXISTS MANAGERS (Username TEXT UNIQUE NOT NULL PRIMARY KEY, Password TEXT NOT NULL, Firstname TEXT NOT NULL, Lastname TEXT NOT NULL, Email BLOB NOT NULL);
INSERT INTO MANAGERS (Username, Password, Firstname, Lastname, Email) VALUES ('JulianChorn', 'password', 'Julian', 'Chorn', 'example123@gmail.com');

-- Table: REQUESTS
CREATE TABLE IF NOT EXISTS REQUESTS (Client TEXT NOT NULL, Title TEXT NOT NULL, Artist TEXT NOT NULL, Date TEXT NOT NULL, Time TEXT NOT NULL, Duration INTEGER NOT NULL, Target_Audience INTEGER NOT NULL, Type TEXT NOT NULL, Category TEXT NOT NULL, PRIMARY KEY (Client, Title));
INSERT INTO REQUESTS (Client, Title, Artist, Date, Time, Duration, Target_Audience, Type, Category) VALUES ('Mousetrap Heart Events', ' Thirsty Merc in the Summertime', ' Thirsty Merc', ' 20-12-24', ' 8pm', 2, 2000, ' gig', ' indoor');
INSERT INTO REQUESTS (Client, Title, Artist, Date, Time, Duration, Target_Audience, Type, Category) VALUES ('Party People United', ' New Years Eve Rock and Dance Gigs', ' Various local musicians', ' 31-12-24', ' 8pm', 3, 1000, ' gig', ' indoor');
INSERT INTO REQUESTS (Client, Title, Artist, Date, Time, Duration, Target_Audience, Type, Category) VALUES ('Party People United', ' BBQ and Udon Winter Festival', ' Jap Jazz', ' 1-6-24', ' 12pm', 3, 4000, ' gig', ' outdoor');
INSERT INTO REQUESTS (Client, Title, Artist, Date, Time, Duration, Target_Audience, Type, Category) VALUES ('Macca Production', ' World Peace for Yoko', ' Paul McCartney', ' 2-2-25', ' 12pm', 2, 35000, ' large live concert', ' outdoor');
INSERT INTO REQUESTS (Client, Title, Artist, Date, Time, Duration, Target_Audience, Type, Category) VALUES ('Taytay Production', ' 1989 Tour Again', ' Taylor Swift', ' 5-4-25', ' 7pm', 2, 90000, ' large live concert', ' convertible');
INSERT INTO REQUESTS (Client, Title, Artist, Date, Time, Duration, Target_Audience, Type, Category) VALUES ('Kimmy Kim', 'KPOP Party', 'DJ Smith', '13-5-25', ' 10pm', 4, 10000, 'disco', 'indoor');

-- Table: VENUES
CREATE TABLE IF NOT EXISTS VENUES (Name TEXT PRIMARY KEY NOT NULL, Capacity INTEGER NOT NULL, "Suitable for" TEXT NOT NULL, Category TEXT NOT NULL, "Booking price / hour" INTEGER NOT NULL);
INSERT INTO VENUES (Name, Capacity, "Suitable for", Category, "Booking price / hour") VALUES ('Esplanade Hotel (The Espy)', 2000, 'gig; disco', 'Indoor', 1000);
INSERT INTO VENUES (Name, Capacity, "Suitable for", Category, "Booking price / hour") VALUES ('The Forum', 3000, 'gig; disco', 'Indoor', 1500);
INSERT INTO VENUES (Name, Capacity, "Suitable for", Category, "Booking price / hour") VALUES ('Corner Hotel', 4000, 'gig; disco', 'Indoor', 2000);
INSERT INTO VENUES (Name, Capacity, "Suitable for", Category, "Booking price / hour") VALUES ('The Tote', 5000, 'gig; disco', 'Indoor', 2500);
INSERT INTO VENUES (Name, Capacity, "Suitable for", Category, "Booking price / hour") VALUES ('170 Russell', 6000, 'gig; disco', 'Indoor', 3000);
INSERT INTO VENUES (Name, Capacity, "Suitable for", Category, "Booking price / hour") VALUES ('The Croxton Bandroom', 7000, 'gig; disco', 'Indoor', 3500);
INSERT INTO VENUES (Name, Capacity, "Suitable for", Category, "Booking price / hour") VALUES ('The Night Cat', 2000, 'gig; disco', 'Indoor', 1000);
INSERT INTO VENUES (Name, Capacity, "Suitable for", Category, "Booking price / hour") VALUES ('Rod Lavern Arena', 15000, 'live concert; festival', 'Convertible', 7500);
INSERT INTO VENUES (Name, Capacity, "Suitable for", Category, "Booking price / hour") VALUES ('Melbourne Cricket Ground (MCG)', 100000, 'large live concert; festival', 'Outdoor', 50000);
INSERT INTO VENUES (Name, Capacity, "Suitable for", Category, "Booking price / hour") VALUES ('Docklands Stadium', 60000, 'large live concert; festival', 'Convertible', 30000);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
