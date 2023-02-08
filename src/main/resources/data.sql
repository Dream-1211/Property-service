
-- Address
INSERT INTO address (id, street, zip_code, state, latitude, longitude)
VALUES
    (1001, '123 Main St', '12345', 'NY', '40.748817', '-73.985428'),
    (1002, '456 Elm St', '67890', 'CA', '37.7749', '-122.4194');
-- Owner
INSERT INTO owner (id, name, user_id, address_id, status)
VALUES
    (1001, 'John Doe', 1001, 1001, 'ACTIVE'),
    (1002, 'Jane Doe', 1002, 1002, 'INACTIVE');

-- PropertyLocation table
INSERT INTO property_location (id, address, latitude, longitude)
VALUES
    (1001, '123 Main St New York', '40.748817', '-73.985428'),
    (1002, '456 Park Ave Los Angeles', '40.748817', '-73.985428'),
    (1003, '789 Broadway Chicago', 'IL''40.748817', '-73.985428'),
    (1004, '789 Broadway Chicago', 'IL''40.748817', '-73.985428'),
    (1005, '789 Broadway Chicago', 'IL''40.748817', '-73.985428');

-- Customer table
INSERT INTO Customer (id, name, status,  address_id, user_id)
VALUES
    (1001, 'John Doe', 'ACTIVE', 1001, 1001),
    (1002, 'Jane Doe', 'ACTIVE',1002, 1002);

-- Property
INSERT INTO property (id, name, location_id, detail, category, status, is_active, owner_id)
VALUES
    (1001, 'My House', 1001, 'My first property', 'HOUSE', 'AVAILABLE', 'YES', 1001),
    (1002, 'My Apartment', 1002, 'My second property', 'APARTMENT', 'AVAILABLE', 'NO', 1002);


INSERT INTO property (id, name, detail, category, status, is_active, owner_id, location_id)
VALUES (1003, 'Villa Rica', '3 BHK independent house with lawn and pool', 'RESIDENTIAL', 'PENDING', false, 1001, 1003),
       (1004, 'Palm Plaza', '4 BHK duplex apartment with garden and gym', 'COMMERCIAL', 'AVAILABLE', true, 1002, 1004),
       (1005, 'Ocean View', '5 BHK villa with ocean view and private beach', 'RESIDENTIAL', 'CONTINGENT', true, 1002,
        1005);

-- CustomerOffer table
INSERT INTO property_offers (id, status, customer_id, property_id, owner_id, amount)
VALUES (1001, 'ACCEPTED', 1001, 1001, 1001, 100000),
       (1003, 'ACCEPTED', 1001, 1003, 1001, 180000),
       (1002, 'ACCEPTED', 1002, 1002, 1002, 200000),
       (1004, 'ACCEPTED', 1002, 1001, 1001, 200000);

-- Property Image

INSERT INTO property_image (id, name, type, property_id)
VALUES (1001, 'Casa Bella - Image 1', 'jpeg', 1002),
       (1002, 'Casa Bella - Image 1', 'jpeg', 1002),
       (1003, 'Casa Bella - Image 2', 'jpeg', 1002),
       (1004, 'Villa Rica - Image 1', 'jpeg', 1003),
       (1005, 'Villa Rica - Image 2', 'jpeg', 1003),
    (1006, 'Palm Plaza - Image 1', 'jpeg',  1004),
    (1007, 'Ocean View - Image 1', 'jpeg',  1005),
    (1008, 'Ocean View - Image 2', 'jpeg',  1005),
    (1009, 'Ocean View - Image 3', 'jpeg',  1005);

