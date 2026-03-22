-- BOXES
INSERT INTO boxes (box_type, name, position, chacras_count, has_estancia, is_mortgage, property_type, province_name, purchase_price, rent_value, type, owner_id) VALUES
('SPECIAL', 'Salida', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'START', NULL),
('PROPERTY', 'Formosa zona sur', 1, 0, 0, 0, 'PROVINCE', 'Formosa', 1000, 100, NULL, NULL),
('PROPERTY', 'Formosa zona centro', 2, 0, 0, 0, 'PROVINCE', 'Formosa', 1000, 100, NULL, NULL),
('PROPERTY', 'Formosa zona norte', 3, 0, 0, 0, 'PROVINCE', 'Formosa', 1200, 120, NULL, NULL),
('PROPERTY', 'Impuesto a los reditos', 4, NULL, NULL, NULL, 'TAXES', NULL, 5000, NULL, NULL, NULL),
('PROPERTY', 'Río Negro zona sur', 5, 0, 0, 0, 'PROVINCE', 'Rio Negro', 2000, 200, NULL, NULL),
('PROPERTY', 'Río Negro zona norte', 6, 0, 0, 0, 'PROVINCE', 'Rio Negro', 2200, 220, NULL, NULL),
('SPECIAL', 'Cobre $2500 Premio Ganadero', 7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'REST', NULL),
('PROPERTY', 'Compañía petrolera', 8, 0, 0, 0, 'COMPANY', NULL, 3800, 300, NULL, NULL),
('PROPERTY', 'Salta zona sur', 9, 0, 0, 0, 'PROVINCE', 'Salta', 2600, 180, NULL, NULL),

('SPECIAL', 'Destino', 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'DESTINY', NULL),
('PROPERTY', 'Salta zona centro', 11, 0, 0, 0, 'PROVINCE', 'Salta', 2600, 200, NULL, NULL),
('PROPERTY', 'Ferrocarril Gral Belgrano', 12, 0, 0, 0, 'RAILWAY', NULL, 3600, 400, NULL, NULL),
('PROPERTY', 'Salta zona norte', 13, 0, 0, 0, 'PROVINCE', 'Salta', 3600, 220, NULL, NULL),
('SPECIAL', 'Comisaria', 14, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'JAIL', NULL),
('SPECIAL', 'Suerte', 15, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'LUCK', NULL),
('PROPERTY', 'Bodega', 16, 0, 0, 0, 'COMPANY', NULL, 3600, 300, NULL, NULL),
('PROPERTY', 'Mendoza zona Sur', 17, 0, 0, 0, 'PROVINCE', 'Mendoza', 3400, 200, NULL, NULL),
('PROPERTY', 'Ferrocarril Gral San Martin', 18, 0, 0, 0, 'RAILWAY', NULL, 3600, 400, NULL, NULL),
('PROPERTY', 'Mendoza zona centro', 19, 0, 0, 0, 'PROVINCE', 'Mendoza', 3400, 220, NULL, NULL),

('PROPERTY', 'Mendoza zona norte', 20, 0, 0, 0, 'PROVINCE', 'Mendoza', 3800, 240, NULL, NULL),
('SPECIAL', 'Descanso', 21, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'REST', NULL),
('PROPERTY', 'Ferrocarril Gral Bartolome Mitre', 22, 0, 0, 0, 'RAILWAY', NULL, 3600, 400, NULL, NULL),
('PROPERTY', 'Santa Fe zona sur', 23, 0, 0, 0, 'PROVINCE', 'Santa Fe', 4200, 300, NULL, NULL),
('PROPERTY', 'Santa Fe zona centro', 24, 0, 0, 0, 'PROVINCE', 'Santa Fe', 4200, 300, NULL, NULL),
('SPECIAL', 'Destino', 25, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'DESTINY', NULL),
('PROPERTY', 'Santa Fe zona norte', 26, 0, 0, 0, 'PROVINCE', 'Santa Fe', 4600, 400, NULL, NULL),
('PROPERTY', 'Ferrocarril Gral urquiza', 27, 0, 0, 0, 'RAILWAY', NULL, 3600, 400, NULL, NULL),
('SPECIAL', 'Free Parking', 28, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'PARKING', NULL),
('PROPERTY', 'Tucuman zona sur', 29, 0, 0, 0, 'PROVINCE', 'Tucuman', 5000, 250, NULL, NULL),

('PROPERTY', 'Tucuman zona norte', 30, 0, 0, 0, 'PROVINCE', 'Tucuman', 5400, 280, NULL, NULL),
('PROPERTY', 'Ingenio', 31, 0, 0, 0, 'COMPANY', NULL, 3600, 300, NULL, NULL),
('PROPERTY', 'Cordoba Zona sur', 32, 0, 0, 0, 'PROVINCE', 'Cordoba', 6000, 300, NULL, NULL),
('PROPERTY', 'Cordoba Zona centro', 33, 0, 0, 0, 'PROVINCE', 'Cordoba', 6000, 320, NULL, NULL),
('PROPERTY', 'Cordoba Zona norte', 34, 0, 0, 0, 'PROVINCE', 'Cordoba', 6400, 350, NULL, NULL),
('SPECIAL', 'Marche Preso', 35, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'JAIL', NULL),
('SPECIAL', 'Suerte', 36, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'LUCK', NULL),
('PROPERTY', 'Buenos Aires zona sur', 37, 0, 0, 0, 'PROVINCE', 'Buenos Aires', 7000, 500, NULL, NULL),
('SPECIAL', 'Destino', 38, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'DESTINY', NULL),
('PROPERTY', 'Buenos Aires zona centro', 39, 0, 0, 0, 'PROVINCE', 'Buenos Aires', 7000, 520, NULL, NULL),

('PROPERTY', 'Buenos Aires zona norte', 40, 0, 0, 0, 'PROVINCE', 'Buenos Aires', 7000, 520, NULL, NULL),
('PROPERTY', 'Impuesto a las ventas', 41, NULL, NULL, NULL, 'TAXES', NULL, NULL, 2000, NULL, NULL);


-- CARDS:


-- LUCK

INSERT INTO cards (type, description, can_be_kept) VALUES
('LUCK', 'Ganó en las carreras. Cobre $3000',0),
('LUCK', 'Ha ganado la grande. Cobre $10.000',0),
('LUCK', 'Cobre $1000 por intereses bancarios', 0),

('LUCK', 'Multa caminera. Pague $400', 0),
('LUCK', 'Multa por exceso de velocidad. Pague $300', 0),
('LUCK', 'Pague $3000 por gastos colegiales..', 0),

('LUCK', 'Por compra de semilla pague al banco $800 por cada chacra. $4000 por cada estancia', 0),
('LUCK', 'Sus propiedades tienen que ser reparadas. Pague al banco $500 por cada chacra y $2500 por cada estancia', 0),

('LUCK', 'Siga hasta la salida',  0),
('LUCK', 'Siga hasta Buenos Aires, Zona norte', 0),
('LUCK', 'Haga un paseo hasta la Bodega. Si pasa por la salida cobre $5000', 0),
('LUCK', 'Siga hasta Salta, Zona Norte. Si pasa por la salida cobre $5000', 0),
('LUCK', 'Siga hasta Santa fe, Zona Norte. Si pasa por la salida cobre $5000', 0),

('LUCK', 'Vuelve 3 pasos atrás', 0),

('LUCK', 'Marche preso directamente',0),
('LUCK', 'Habeas corpus concedido. Con esta tarjeta sale usted gratuitamente de la Comisaria. Consérvela o vendala', 1);


-- DESTINY

INSERT INTO cards (type, description, can_be_kept) VALUES
('DESTINY', 'Por venta de acciones, cobre $1000', 0),
('DESTINY', 'Ha ganado un concurso ganadero. Cobre $2000',0),
('DESTINY', 'Herede $2000', 0),
('DESTINY', 'Devolución de impuesto. Cobre $400', 0),
('DESTINY', 'Ha ganado un concurso agrícola. Cobre $2000', 0),
('DESTINY', 'Error en los cálculos del banco. Cobre $4000', 0),
('DESTINY', 'Ha obtenido un segundo premio de belleza. Cobre $200', 0),
('DESTINY', '5% de interés sobre cédulas hipotecarias. Cobre $500',0),

('DESTINY', 'Es su cumpleaños. Cobre $200 de cada uno de sus jugadores', 0),

('DESTINY', 'Siga hasta la salida', 0),
('DESTINY', 'Vuelve atrás hacia Formosa Zona Sur', 0),

('DESTINY', 'Gastos de farmacia. Pague $1000', 0),
('DESTINY', 'Pague su póliza de seguro con $1000', 0),
('DESTINY', 'Pague $200 de multa o levante una tarjeta de SUERTE', 0),

('DESTINY', 'Marche preso directamente', 0),
('DESTINY', 'Con esta tarjeta sale usted de la Comisaria. Consérvela hasta utilizarla o venderla', 1);


-- EFFECTS OF THE CARDS (OR BY CARDS)

-- LUCK:

INSERT INTO card_effects (card_id,effect_type,amount_boxes,to_box_id,cash) VALUES
(1,'RECEIVE_FROM_BANK',NULL,NULL,3000),
(2,'RECEIVE_FROM_BANK',NULL,NULL,10000),
(3,'RECEIVE_FROM_BANK',NULL,NULL,1000),
(4,'PAY_TO_BANK',NULL,NULL,400),
(5,'PAY_TO_BANK',NULL,NULL,300),
(6,'PAY_TO_BANK',NULL,NULL,3000),
(7,'PAY_PER_PROPERTY',NULL,NULL,NULL),
(8,'PAY_PER_PROPERTY',NULL,NULL,NULL),
(9,'MOVE_TO_BOX',NULL,1,NULL),
(10,'MOVE_TO_BOX',NULL,41,NULL),

(11,'MOVE_TO_BOX',NULL,17,NULL),
(11,'RECEIVE_FROM_BANK',NULL,NULL,5000),

(12,'MOVE_TO_BOX',NULL,14,NULL),
(12,'RECEIVE_FROM_BANK',NULL,NULL,5000),

(13,'MOVE_TO_BOX',NULL,27,NULL),
(13,'RECEIVE_FROM_BANK',NULL,NULL,5000),

(14,'MOVE_X_AMOUNT',-3,NULL,NULL),
(15,'GO_TO_JAIL',NULL,15,NULL),
(16,'GET_OUT_OF_JAIL',NULL,NULL,NULL);


-- DESTINY:
INSERT INTO card_effects (card_id,effect_type,amount_boxes,to_box_id,cash) VALUES
(17,'RECEIVE_FROM_BANK',NULL,NULL,1000),
(18,'RECEIVE_FROM_BANK',NULL,NULL,2000),
(19,'RECEIVE_FROM_BANK',NULL,NULL,2000),
(20,'RECEIVE_FROM_BANK',NULL,NULL,400),
(21,'RECEIVE_FROM_BANK',NULL,NULL,2000),
(22,'RECEIVE_FROM_BANK',NULL,NULL,4000),
(23,'RECEIVE_FROM_BANK',NULL,NULL,200),
(24,'RECEIVE_FROM_BANK',NULL,NULL,500),
(25,'RECEIVE_FROM_ALL_PLAYERS',NULL,NULL,200),
(26,'MOVE_TO_BOX',NULL,1,NULL),
(27,'MOVE_TO_BOX',NULL,2,NULL),
(28,'PAY_TO_BANK',NULL,NULL,1000),
(29,'PAY_TO_BANK',NULL,NULL,1000),

(30,'PAY_TO_BANK',NULL,NULL,200),
-- aca se supone q vamos a hacer para que esa opcion la elija el usuario. O paga la multa o saca una carta suerte
(30,'PICK_UP_A_LUCKY_CARD',NULL,NULL,0),

(31,'GO_TO_JAIL',NULL,15,NULL),
(32,'GET_OUT_OF_JAIL',NULL,NULL,NULL);