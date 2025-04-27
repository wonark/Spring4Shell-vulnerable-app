## Spring4Shell 취약점 (원격 코드 실행) (CVE-2022-22965)
> WHS#3 - 이재원

Spring Framework의 Spring MVC 및 Spring WebFlux 모듈에서 데이터 바인딩 과정의 경로 탐색(path traversal) 취약점을 이용한 원격 코드 실행(RCE) 취약점이다.
취약 버전(≤5.3.18, ≤5.2.20)에서는 공격자가 특수하게 조작된 HTTP 요청을 보내어 애플리케이션 서버 내 임의 코드를 실행할 수 있다.

References:
- https://github.com/advisories/GHSA-p6mc-m468-83gw  
- https://nvd.nist.gov/vuln/detail/CVE-2022-22965
- https://www.igloo.co.kr/security-information/spring4shellcve-2022-22965-%EC%B7%A8%EC%95%BD%EC%A0%90-%EC%9B%90%EC%9D%B8%EB%B6%84%EC%84%9D-%EB%B0%8F-%EB%8C%80%EC%9D%91%EB%B0%A9%EC%95%88/

---

### 환경 설정

1. 프로젝트 클론  
   ```
   git clone https://github.com/jaewonlee/Spring4Shell-vulnerable-app.git
   cd Spring4Shell-vulnerable-app
   ```

2. Docker에서 compose로 가동
  ```
    docker compose up -d
  ```
![image](https://github.com/user-attachments/assets/c8b5c9ec-b390-4dd9-922a-e396a303df06)

---

### PoC 취약점 재현

컨테이너 빌드 및 실행 (서버 + PoC 스크립트 포함)
```
docker compose up --build -d
```

서버 정상 동작 확인
```
curl http://localhost:8080/helloworld/greeting
# → {"id":1,"content":"Hello, World!"}
```

RCE 페이로드 전송 및 결과 확인
```
# PoC 스크립트가 컨테이너 ENTRYPOINT로 포함되어 자동 실행되므로,
# 컨테이너 로그에서 직접 결과를 확인.
docker logs spring4shell_poc | grep uid=
# → uid=1000(...), gid=1000(...)
```

컨테이너 정리
`docker compose down`


``` docker-compose.yml
services:
  app:
    build: .                # Dockerfile 기반 빌드
    container_name: spring4shell_poc
    ports:
      - "8080:8080"
```
