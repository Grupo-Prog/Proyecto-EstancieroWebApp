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


-- CARDS:


-- LUCK

INSERT INTO cards (type, description, effect_type, amount, can_be_kept) VALUES
('LUCK', 'Ganó en las carreras. Cobre $3000', 'RECEIVE_FROM_BANK', 3000, 0),
('LUCK', 'Ha ganado la grande. Cobre $10.000', 'RECEIVE_FROM_BANK', 10000, 0),
('LUCK', 'Cobre $1000 por intereses bancarios', 'RECEIVE_FROM_BANK', 1000, 0),

('LUCK', 'Multa caminera. Pague $400', 'PAY_TO_BANK', 400, 0),
('LUCK', 'Multa por exceso de velocidad. Pague $300', 'PAY_TO_BANK', 300, 0),
('LUCK', 'Pague $3000 por gastos colegiales..', 'PAY_TO_BANK', 3000, 0),
('LUCK', 'Por compra de semilla pague al banco $800 por cada chacra. $4000 por cada estancia', 'PAY_TO_BANK', null, 0),
('LUCK', 'Sus propiedades tienen que ser reparadas. Pague al banco $500 por cada chacra y $2500 por cada estancia', 'PAY_TO_BANK', null, 0),

('LUCK', 'Siga hasta la salida', 'MOVE_TO_BOX',   1,  0),
('LUCK', 'Siga hasta Buenos Aires, Zona norte', 'MOVE_TO_BOX',  41, 0),
('LUCK', 'Haga un paseo hasta la Bodega. Si pasa por la salida cobre $5000', 'MOVE_TO_BOX',  5000, 0),
('LUCK', 'Siga hasta Salta, Zona Norte. Si pasa por la salida cobre $5000', 'MOVE_TO_BOX',  5000, 0),
('LUCK', 'Siga hasta Santa fe, Zona Norte. Si pasa por la salida cobre $5000', 'MOVE_TO_BOX',  5000, 0),

('LUCK', 'Vuelve 3 pasos atrás', 'MOVE_X_AMOUNT', 3, 0),

('LUCK', 'Marche preso directamente', 'GO_TO_JAIL', 15,  0),
('LUCK', 'Habeas corpus concedido. Con esta tarjeta sale usted gratuitamente de la Comisaria. Consérvela o vendala', 'GET_OUT_OF_JAIL',  NULL, 1);


-- DESTINY

INSERT INTO cards (type, description, effect_type, amount, can_be_kept) VALUES
('DESTINY', 'Por venta de acciones, cobre $1000', 'RECEIVE_FROM_BANK', 1000,  0),
('DESTINY', 'Ha ganado un concurso ganadero. Cobre $2000', 'RECEIVE_FROM_BANK', 2000,  0),
('DESTINY', 'Herede $2000', 'RECEIVE_FROM_BANK', 2000,  0),
('DESTINY', 'Devolución de impuesto. Cobre $400', 'RECEIVE_FROM_BANK', 400,  0),
('DESTINY', 'Ha ganado un concurso agrícola. Cobre $2000', 'RECEIVE_FROM_BANK', 2000,  0),
('DESTINY', 'Error en los cálculos del banco. Cobre $4000', 'RECEIVE_FROM_BANK', 4000,  0),
('DESTINY', 'Ha obtenido un segundo premio de belleza. Cobre $200', 'RECEIVE_FROM_BANK', 200,  0),
('DESTINY', '5% de interés sobre cédulas hipotecarias. Cobre $500', 'RECEIVE_FROM_BANK', 500,  0),

('DESTINY', 'Es su cumpleaños. Cobre $200 de cada uno de sus jugadores', 'RECEIVE_FROM_ALL_PLAYERS', 200,  0),

('DESTINY', 'Siga hasta la salida', 'MOVE_TO_BOX', 1, 0),
('DESTINY', 'Vuelve atrás hacia Formosa Zona Sur', 'MOVE_TO_BOX', 2, 0),

('DESTINY', 'Gastos de farmacia. Pague $1000', 'PAY_TO_BANK', 1000,  0),
('DESTINY', 'Pague su póliza de seguro con $1000', 'PAY_TO_BANK', 1000,  0),
('DESTINY', 'Pague $200 de multa o levante una tarjeta de SUERTE', 'PAY_TO_BANK', 200,  0),

('DESTINY', 'Marche preso directamente', 'GO_TO_JAIL', 15,  0),
('DESTINY', 'Con esta tarjeta sale usted de la Comisaria. Consérvela hasta utilizarla o venderla', 'GET_OUT_OF_JAIL',  NULL, 1);

