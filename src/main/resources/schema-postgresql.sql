CREATE TABLE IF NOT EXISTS posts (
    id            UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    titulo        VARCHAR(100) NOT NULL,
    ideia         TEXT,
    plataforma    VARCHAR(50),
    status        VARCHAR(50),
    data_prevista VARCHAR(20)
);