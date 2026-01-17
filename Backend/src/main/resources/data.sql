
INSERT INTO cards (type, description, effect_type, amount, can_be_kept) VALUES
('LUCK', 'Pagás $150 al banco', 'PAY_TO_BANK', 150, 0),
('LUCK', 'Pagás multa al banco por $100', 'PAY_TO_BANK', 100, 0),

('LUCK', 'El banco te paga un dividendo por $100', 'RECEIVE_FROM_BANK', 100,  0),
('LUCK', 'Liquidas tu prestamo para construccion. Cobras $150', 'RECEIVE_FROM_BANK', 150,  0),

('LUCK', 'Pagás $100 a cada jugador', 'PAY_TO_ALL_PLAYERS', 100,  0),
('LUCK', 'Te han elegido presidente de la mesa directiva. Paga $50 a cada jugador', 'PAY_TO_ALL_PLAYERS', 50,  0),

('LUCK', 'Cobrás $100 de cada jugador', 'RECEIVE_FROM_ALL_PLAYERS', 100, 0),
('LUCK', 'Cobrás $200 de cada jugador', 'RECEIVE_FROM_ALL_PLAYERS', 200, 0),

('LUCK', 'Vas directo a la cárcel', 'GO_TO_JAIL', NULL,  0),
('LUCK', 'Vas directo a la cárcel', 'GO_TO_JAIL', NULL,  0),

('LUCK', 'Salís de la cárcel gratis. Puedes guardar esta carta', 'GET_OUT_OF_JAIL',  NULL, 1),
('LUCK', 'Salís de la cárcel gratis. Puedes guardar esta carta', 'GET_OUT_OF_JAIL',  NULL, 1),

('LUCK', 'Avanzás 3 casilleros', 'MOVE_X_AMOUNT',  3, 0),
('LUCK', 'Retrocedés 3 casilleros', 'MOVE_X_AMOUNT', 3, 0),

('LUCK', 'Avanzás hasta el ferrocarril de la plata', 'MOVE_TO_BOX',  17, 0),
('LUCK', 'Avanzás hasta la salida', 'MOVE_TO_BOX',   40,  0);


INSERT INTO cards (type, description, effect_type, amount, can_be_kept) VALUES
('DESTINY', 'Paga cuotas de hospital por $100', 'PAY_TO_BANK', 100,  0),
('DESTINY', 'Cuotas medicas. Paga $50', 'PAY_TO_BANK', 50,  0),

('DESTINY', 'Recibes $120 por servicios de asesoria', 'RECEIVE_FROM_BANK', 120,  0),
('DESTINY', 'Error bancario a tu favor. Cobra $200', 'RECEIVE_FROM_BANK', 200,  0),

('DESTINY', 'Pagás $100 a cada jugador', 'PAY_TO_ALL_PLAYERS', 100,  0),
('DESTINY', 'Pagás $200 a cada jugador', 'PAY_TO_ALL_PLAYERS', 200,  0),

('DESTINY', 'Es tu cumpleaños recibes $50 de cada jugador', 'RECEIVE_FROM_ALL_PLAYERS', 50,  0),
('DESTINY', 'Es tu cumpleaños recibes $100 de cada jugador', 'RECEIVE_FROM_ALL_PLAYERS', 100,  0),

('DESTINY', 'Vas directo a la cárcel', 'GO_TO_JAIL', NULL, 0),
('DESTINY', 'Vas directo a la cárcel', 'GO_TO_JAIL', NULL, 0),

('DESTINY', 'Salís de la cárcel gratis. Puedes guardar esta carta', 'GET_OUT_OF_JAIL', NULL, 1),
('DESTINY', 'Salís de la cárcel gratis. Puedes guardar esta carta', 'GET_OUT_OF_JAIL', NULL, 1),

('DESTINY', 'Avanzás 5 casilleros', 'MOVE_X_AMOUNT',  5, 0),
('DESTINY', 'Retrocedés 3 casilleros', 'MOVE_X_AMOUNT',  3, 0 ),

('DESTINY', 'Avanzás hasta la Chacra Buenos Aires', 'MOVE_TO_BOX', 5,  0),
('DESTINY', 'Avanzás hasta la Salida', 'MOVE_TO_BOX', 40, 0);



