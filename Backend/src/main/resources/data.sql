-- BOXES
INSERT INTO boxes (box_type, name, position, chacras_count, has_estancia, is_mortgage, property_type, province_name, purchase_price, rent_value, type, owner_id) VALUES
('SPECIAL', 'Salida', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'START', NULL),
('PROPERTY', 'Formosa zona sur', 2, 0, 0, 0, 'PROVINCE', 'Formosa', 1000, 100, NULL, NULL),
('PROPERTY', 'Formosa zona centro', 3, 0, 0, 0, 'PROVINCE', 'Formosa', 1000, 100, NULL, NULL),
('PROPERTY', 'Formosa zona norte', 4, 0, 0, 0, 'PROVINCE', 'Formosa', 1200, 120, NULL, NULL),
('PROPERTY', 'Impuesto a los reditos', 5, NULL, NULL, NULL, 'TAXES', NULL, 5000, NULL, NULL, NULL),
('PROPERTY', 'Río Negro zona sur', 6, 0, 0, 0, 'PROVINCE', 'Rio Negro', 2000, 200, NULL, NULL),
('PROPERTY', 'Río Negro zona norte', 7, 0, 0, 0, 'PROVINCE', 'Rio Negro', 2200, 220, NULL, NULL),
('SPECIAL', 'Cobre $2500 Premio Ganadero', 8, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'REST', NULL),
('PROPERTY', 'Compañía petrolera', 9, 0, 0, 0, 'COMPANY', NULL, 3800, 300, NULL, NULL),
('PROPERTY', 'Salta zona sur', 10, 0, 0, 0, 'PROVINCE', 'Salta', 2600, 180, NULL, NULL),

('SPECIAL', 'Destino', 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'DESTINY', NULL),
('PROPERTY', 'Salta zona centro', 12, 0, 0, 0, 'PROVINCE', 'Salta', 2600, 200, NULL, NULL),
('PROPERTY', 'Ferrocarril Gral Belgrano', 13, 0, 0, 0, 'RAILWAY', NULL, 3600, 400, NULL, NULL),
('PROPERTY', 'Salta zona norte', 14, 0, 0, 0, 'PROVINCE', 'Salta', 3600, 220, NULL, NULL),
('SPECIAL', 'Comisaria', 15, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'JAIL', NULL),
('SPECIAL', 'Suerte', 16, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'LUCK', NULL),
('PROPERTY', 'Bodega', 17, 0, 0, 0, 'COMPANY', NULL, 3600, 300, NULL, NULL),
('PROPERTY', 'Mendoza zona Sur', 18, 0, 0, 0, 'PROVINCE', 'Mendoza', 3400, 200, NULL, NULL),
('PROPERTY', 'Ferrocarril Gral San Martin', 19, 0, 0, 0, 'RAILWAY', NULL, 3600, 400, NULL, NULL),
('PROPERTY', 'Mendoza zona centro', 20, 0, 0, 0, 'PROVINCE', 'Mendoza', 3400, 220, NULL, NULL),

('PROPERTY', 'Mendoza zona norte', 21, 0, 0, 0, 'PROVINCE', 'Mendoza', 3800, 240, NULL, NULL),
('SPECIAL', 'Descanso', 22, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'REST', NULL),
('PROPERTY', 'Ferrocarril Gral Bartolome Mitre', 23, 0, 0, 0, 'RAILWAY', NULL, 3600, 400, NULL, NULL),
('PROPERTY', 'Santa Fe zona sur', 24, 0, 0, 0, 'PROVINCE', 'Santa Fe', 4200, 300, NULL, NULL),
('PROPERTY', 'Santa Fe zona centro', 25, 0, 0, 0, 'PROVINCE', 'Santa Fe', 4200, 300, NULL, NULL),
('SPECIAL', 'Destino', 26, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'DESTINY', NULL),
('PROPERTY', 'Santa Fe zona norte', 27, 0, 0, 0, 'PROVINCE', 'Santa Fe', 4600, 400, NULL, NULL),
('PROPERTY', 'Ferrocarril Gral urquiza', 28, 0, 0, 0, 'RAILWAY', NULL, 3600, 400, NULL, NULL),
('SPECIAL', 'Free Parking', 29, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'PARKING', NULL),
('PROPERTY', 'Tucuman zona sur', 30, 0, 0, 0, 'PROVINCE', 'Tucuman', 5000, 250, NULL, NULL),

('PROPERTY', 'Tucuman zona norte', 31, 0, 0, 0, 'PROVINCE', 'Tucuman', 5400, 280, NULL, NULL),
('PROPERTY', 'Ingenio', 32, 0, 0, 0, 'COMPANY', NULL, 3600, 300, NULL, NULL),
('PROPERTY', 'Cordoba Zona sur', 33, 0, 0, 0, 'PROVINCE', 'Cordoba', 6000, 300, NULL, NULL),
('PROPERTY', 'Cordoba Zona centro', 34, 0, 0, 0, 'PROVINCE', 'Cordoba', 6000, 320, NULL, NULL),
('PROPERTY', 'Cordoba Zona norte', 35, 0, 0, 0, 'PROVINCE', 'Cordoba', 6400, 350, NULL, NULL),
('SPECIAL', 'Marche Preso', 36, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'JAIL', NULL),
('SPECIAL', 'Suerte', 37, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'LUCK', NULL),
('PROPERTY', 'Buenos Aires zona sur', 38, 0, 0, 0, 'PROVINCE', 'Buenos Aires', 7000, 500, NULL, NULL),
('SPECIAL', 'Destino', 39, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'DESTINY', NULL),
('PROPERTY', 'Buenos Aires zona centro', 40, 0, 0, 0, 'PROVINCE', 'Buenos Aires', 7000, 520, NULL, NULL),

('PROPERTY', 'Buenos Aires zona norte', 41, 0, 0, 0, 'PROVINCE', 'Buenos Aires', 7000, 520, NULL, NULL),
('PROPERTY', 'Impuesto a las ventas', 42, NULL, NULL, NULL, 'TAXES', NULL, NULL, 2000, NULL, NULL);


-- CARDS

INSERT INTO cards (type, description, effect_type, amount, can_be_kept) VALUES
('LUCK', 'Pagás $150 al banco', 'PAY_TO_BANK', 150, 0),
('LUCK', 'Pagás multa al banco por $100', 'PAY_TO_BANK', 100, 0),

('LUCK', 'El banco te paga un dividendo por $100', 'RECEIVE_FROM_BANK', 100,  0),
('LUCK', 'Liquidas tu prestamo para construccion. Cobras $150', 'RECEIVE_FROM_BANK', 150,  0),

('LUCK', 'Pagás $100 a cada jugador', 'PAY_TO_ALL_PLAYERS', 100,  0),
('LUCK', 'Te han elegido presidente de la mesa directiva. Paga $50 a cada jugador', 'PAY_TO_ALL_PLAYERS', 50,  0),

('LUCK', 'Cobrás $100 de cada jugador', 'RECEIVE_FROM_ALL_PLAYERS', 100, 0),
('LUCK', 'Cobrás $200 de cada jugador', 'RECEIVE_FROM_ALL_PLAYERS', 200, 0),

('LUCK', 'Marche preso', 'GO_TO_JAIL', 15,  0),
('LUCK', 'Marche preso', 'GO_TO_JAIL', 15,  0),

('LUCK', 'Salís de la cárcel gratis. Puedes guardar esta carta', 'GET_OUT_OF_JAIL',  NULL, 1),
('LUCK', 'Salís de la cárcel gratis. Puedes guardar esta carta', 'GET_OUT_OF_JAIL',  NULL, 1),

('LUCK', 'Avanzás 3 casilleros', 'MOVE_X_AMOUNT',  3, 0),
('LUCK', 'Retrocedés 3 casilleros', 'MOVE_X_AMOUNT', 3, 0),

('LUCK', 'Avanzás hasta el Ferrocarril de San Martin', 'MOVE_TO_BOX',  19, 0),
('LUCK', 'Avanzás hasta la salida', 'MOVE_TO_BOX',   1,  0);


INSERT INTO cards (type, description, effect_type, amount, can_be_kept) VALUES
('DESTINY', 'Paga cuotas de hospital por $100', 'PAY_TO_BANK', 100,  0),
('DESTINY', 'Cuotas medicas. Paga $50', 'PAY_TO_BANK', 50,  0),

('DESTINY', 'Recibes $120 por servicios de asesoria', 'RECEIVE_FROM_BANK', 120,  0),
('DESTINY', 'Error bancario a tu favor. Cobra $200', 'RECEIVE_FROM_BANK', 200,  0),

('DESTINY', 'Pagás $100 a cada jugador', 'PAY_TO_ALL_PLAYERS', 100,  0),
('DESTINY', 'Pagás $200 a cada jugador', 'PAY_TO_ALL_PLAYERS', 200,  0),

('DESTINY', 'Es tu cumpleaños recibes $50 de cada jugador', 'RECEIVE_FROM_ALL_PLAYERS', 50,  0),
('DESTINY', 'Es tu cumpleaños recibes $100 de cada jugador', 'RECEIVE_FROM_ALL_PLAYERS', 100,  0),

('DESTINY', 'Marche preso', 'GO_TO_JAIL', 15, 0),
('DESTINY', 'Marche preso', 'GO_TO_JAIL', 15, 0),

('DESTINY', 'Salís de la cárcel gratis. Puedes guardar esta carta', 'GET_OUT_OF_JAIL', NULL, 1),
('DESTINY', 'Salís de la cárcel gratis. Puedes guardar esta carta', 'GET_OUT_OF_JAIL', NULL, 1),

('DESTINY', 'Avanzás 5 casilleros', 'MOVE_X_AMOUNT',  5, 0),
('DESTINY', 'Retrocedés 3 casilleros', 'MOVE_X_AMOUNT',  3, 0 ),

('DESTINY', 'Avanzás hasta la Provincia de Mendoza zona sur', 'MOVE_TO_BOX', 18,  0),
('DESTINY', 'Avanzás hasta la salida', 'MOVE_TO_BOX', 1, 0);


