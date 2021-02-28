# springDataRedis

https://docs.spring.io/spring-data/data-redis/docs/current/reference/html/#redis

--> 기본적으로 위의 사이트를 보며 공부.
## 2021년 2월 27일 ~ 2021년 2월 28일 Redis 공부

### 링크는 참고용 사이트.

1. Redis Cache 적용 

https://programmerfriend.com/ultimate-guide-to-redis-cache-with-spring-boot-2-and-spring-data-redis/

https://daddyprogrammer.org/post/3217/redis-springboot2-spring-data-redis-cacheable-cacheput-cacheevict/

2. Redis 간단 명령어 

https://firstboos.tistory.com/entry/redis-%EA%B0%84%EB%8B%A8-%EB%AA%85%EB%A0%B9%EC%96%B4-%EC%A0%95%EB%A6%AC
 
https://blog.geunho.dev/til/redis/ops/

https://realmojo.tistory.com/172

3. 현재 구현한 것.
    - 구현하려는 것 : RDB에 있는 데이터를 불러와 특정 값을 컨버트하여 Redis에 넣는다.
    - 해당 데이터는 자주 불러와야하며, 어떤 작업이든 걸쳐가야하는 것을 바탕으로 한다.
    - @Table와 @RedisHash를 사용하여 구현.
    
    
### 다음에 해야할 것은 대용량 데이터를 넣어서 RDB 조회 속도와 Redis 조회를 비교해야할 듯함.
