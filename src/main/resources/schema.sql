DROP TABLE IF EXISTS notice;

CREATE TABLE notice(
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       title VARCHAR(30),
                       content VARCHAR(100),
                       who VARCHAR(30),
                       views INT DEFAULT 0,
                       createDate TIMESTAMP NOT NULL,
                       updateDate TIMESTAMP NOT NULL
);

DROP TABLE IF EXISTS payments;

CREATE TABLE payments (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,       -- 결제 고유 ID
                          partner_id BIGINT,
                          user_id BIGINT NOT NULL,                            -- 결제를 한 사용자 ID
                          order_id BIGINT NOT NULL,                           -- 관련 주문 ID
                          payment_amount DECIMAL(15, 2) NOT NULL,          -- 결제 금액
                          payment_date DATETIME NOT NULL,                  -- 결제 일시
                          payment_method VARCHAR(50),                      -- 결제 수단 (예: 카드, 계좌이체, 페이팔 등)
                          pg_provider_id BIGINT NULL,                         -- PG사 ID (결제 대행사 식별자, 계좌이체의 경우 NULL)
                          status VARCHAR(20) DEFAULT 'Completed',          -- 결제 상태 (예: Completed, Pending, Failed 등)
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 레코드 생성 시각
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 레코드 업데이트 시각
);

DROP TABLE IF EXISTS settlements;

CREATE TABLE settlements (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,             -- 정산 고유 ID
                             partner_id INT,                               -- 정산이 관련된 파트너 ID
                             total_amount DECIMAL(15, 2) NOT NULL,         -- 총 정산 금액
                             status VARCHAR(20) DEFAULT 'pending',         -- 정산 상태 (예: pending, completed)
                             payment_date TIME,                     -- 거래일자
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 레코드 생성 시각
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 레코드 업데이트 시각
);
