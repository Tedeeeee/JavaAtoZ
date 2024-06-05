package src.sec07.chap07;

import src.sec03.chap04.Side;
import src.sec03.chap04.Swordman;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

/**
 *  자바 8에서 등장했다
 *  - Future보다 편리하고 강력한 기능들을 제공한다
 *  -- 연속되는 작업들을 비동기적으로, 함수형으로 작성했다
 *  -- 여러 비동기 작업들을 조합하고 병렬적으로 실행이 가능하다
 *  -- 예외 처리를 위한 기능들을 제공한다
 *
 *  또한 CompletableFuture의 이후 데이터 처리 메소드를 보면 Funtional의 메소드와 같다
 *  Customer -> accept
 *  Funtion -> apply
 *
 */
public class Main {

    public static void main(String[] args) {
        try {
            //supplyAsyncEx();
            //thenAcceptEx1();
            //thenAcceptEx2();
            //thenAppltEx1();
            //thenApplyEx2();
            //exceptionallyEx(false);
            //thenComposeEx();
            //allOfEx1();
            //allOfEx2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void takeTime(boolean error) {
        // 시간이 걸리고 예외 가능성 있는 작업 시뮬레이션
        try {
            int randMilliSec = new Random().nextInt(1000, 1500);

            Thread.sleep(randMilliSec);
            System.out.printf(".....%f초 경과....%n", randMilliSec / 1000.0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (error) throw new RuntimeException("⚠️ 오류 발생");
    }

    // CompletableFuture를 사용했지만 Future와 크게 다를게 없다.
    public static void supplyAsyncEx() throws ExecutionException, InterruptedException {

        // supplyAsync : Supplier를 받아 비동기 작업을 실행
        // - 결과를 CompletableFuture의 형태로 반환한다
        CompletableFuture<String> getHello = CompletableFuture.supplyAsync(() -> {
            takeTime(false);
            return "Hello";
        });

        System.out.println("- - - get 사용 전 - - -");

        // Future처럼 get을 사용하면 blocking 발생
        // - 값을 받아올 때까지 다음 코드의 진행을 막는다
        String hello = getHello.get();

        System.out.println("- - - get 사용 후 - - -");
        System.out.println(hello);
    }

    public static void thenAcceptEx1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> getHello = CompletableFuture.supplyAsync(() -> {
            System.out.println("값을 받아온다");
            takeTime(false);
            return "Hello";
        });

        // thenAccept : 받아온 값을 Consumer(인자 O, 반환 X)로 실행한다
        // - 이전 과정으로부터 얻은 값("Hello")으로 할 일을 지정한다
        // - 여기서는 일을 정해두기만 할 뿐, 호출은 get으로한다
        // - get을 호출해도, supplyAsync 작업이 끝나고 나서야 실행이 된다
        CompletableFuture<Void> printHello = getHello.thenAccept(s -> {
            System.out.println("받아온 값을 처리한다");
            takeTime(false);
            System.out.println(s);
        });

        System.out.println("- - - 중간에 다른 코드들을 진행 - - -");

        // get으로 호출하지 않으면 비동기로 실행된 쓰레드가 return을 내보이지 않는다.
        printHello.get();
    }

    public static void thenAcceptEx2() throws ExecutionException, InterruptedException {
        // 비동기 메소드 체이닝
        // supplyAsync 에서 사용한 변수를 이후 데이터를 처리하는 메소드에서도 사용이 가능하다
        CompletableFuture<Void> print5nums = CompletableFuture.supplyAsync(() -> {
            List<Integer> ints = new ArrayList<>();
            IntStream.range(0, 5).forEach(i -> {
                takeTime(false);
                ints.add(i);
            });
            return ints;
        }).thenAccept(list -> {
            takeTime(false);
            list.stream().forEach(System.out::print);
        });

        System.out.println("- - - 중간에 다른 코드 실행(Main Method) - - -");

        print5nums.get();
    }

    public static void thenAppltEx1 () throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            takeTime(false);
            return new Random().nextInt(0, 6) + 1;
        }).thenApply(
                // thenApply : 얻어온 값을 Function에 넣어 다른 값을 반환한다
                i -> {
                    takeTime(false);
                    return "이번 당첨 숫자는..." + "\"" + i + "\"" + "!!!";
                }
        ).thenAccept(
                System.out::println
        ).get();

        System.out.println("축하드립니다!");

        // 이렇게 여러개의 결과물을 위해 apply, accept 를 연속해서 사용할 수 있고 마지막에 get을 바로 출력할 수 있다.
        // 하지만 이렇게 하면 만약 메인 쓰레드에서 처리하는 로직이 있다면 실행이 안된다.
    }

    public static void thenApplyEx2 () throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            takeTime(false);
            return new Random().nextBoolean();

            // Apply의 연속 사용
        }).thenApply(b -> {
            takeTime(false);
            System.out.println("1번 apply");
            return new Swordman(b ? Side.RED : Side.BLUE);
        }).thenApply(s -> {
            takeTime(false);
            System.out.println("2번 apply");
            return s.toString();
        }).thenAccept(
                System.out::println
        ).get();
    }

    // error를 잡아서 진행해보는 메소드
    public static void exceptionallyEx(Boolean error) throws ExecutionException, InterruptedException {
        System.out.println("안녕!!!");
        CompletableFuture.supplyAsync(() -> {
            takeTime(error);
            return "ㅇㅇ 안녕!!";
        }).exceptionally(e -> {
            // exceptionally는 오류가 발생하면 대체할 수 있는 값을 반환한다.
            e.printStackTrace();
            return "안녕 못해...";
        }).thenApply(s -> {
            takeTime(false);
            // 결국 오류가 나더라도 오류가 난 값으로 또다시 일을 처리한다.
            return "대답 : " + s;
        }).thenAccept(
                System.out::println
        ).get();
    }

    private static CompletableFuture<Swordman> getChamp(Side side) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("- - - 🤺 %s 검사 훈련 시작 - - -%n", side.getName());
            takeTime(false);
            return new Swordman(side);
        }).thenApply(c -> {
            System.out.printf("- - - 💪 %s 검사 체력 훈련 - - -%n", side.getName());
            takeTime(false);
            c.hp += new Random().nextInt(0, 3);
            return c;
        });
    }

    public static void thenComposeEx() throws ExecutionException, InterruptedException {
        CompletableFuture<Swordman> getBlueChamp = getChamp(Side.BLUE);
        CompletableFuture<Swordman> getRedChamp = getChamp(Side.RED);

        System.out.println("\n===== 양 진영 검사 훈련중 =====\n");

        // thenCompose : 두 CompleteFuture의 결과를 조합
        // - 두 작업이 동시에 진행됨을 주목해야한다.
        getBlueChamp.thenCompose(
                b -> getRedChamp.thenApply(
                        r -> {
                            if (b.hp == r.hp) throw new RuntimeException();
                            return b.hp >= r.hp ? b : r;
                        })
                )
                .thenApply(Swordman::toString)
                .thenApply(s -> "🏆 승자 : " + s)
                .exceptionally(e -> "⚔ 무승부")
                .thenAccept(System.out::println)
                .get();
    }

    public static void thenCombineEx() {
        CompletableFuture<Swordman> getBlueChamp = getChamp(Side.BLUE);
        CompletableFuture<Swordman> getRedChamp = getChamp(Side.RED);

        System.out.println("\n===== 양 진영 검사 훈련중 =====\n");

        try {
            // thenCombine : thenCompose와 문법만 다르다
            getBlueChamp.thenCombine(
                            getRedChamp,
                            (b, r) -> {
                                if (b.hp == r.hp) throw new RuntimeException();
                                return b.hp >= r.hp ? b : r;
                            })
                    .thenApply(Swordman::toString)
                    .thenApply(s -> "🏆 승자 : " + s)
                    .exceptionally(e -> "⚔ 무승부")
                    .thenAccept(System.out::println)
                    .get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static CompletableFuture<Integer> rollDiceFuture() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("주사위 굴림");

            takeTime(new Random().nextBoolean());
            int result = new Random().nextInt(0, 6) + 1;
            System.out.println("🎲 : " + result);
            return result;
        }).exceptionally(e -> -1); // 예외를 대비한다.
    }

    public static void allOfEx1() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> roll1 = rollDiceFuture();
        CompletableFuture<Integer> roll2 = rollDiceFuture();
        CompletableFuture<Integer> roll3 = rollDiceFuture();
        CompletableFuture<Integer> roll4 = rollDiceFuture();
        CompletableFuture<Integer> roll5 = rollDiceFuture();

        // allOf : 여러 CompletableFuture 작업을 동시에 진행
        // - thenRun 메소드에서 결과들을 동기적으로 종합
        CompletableFuture.allOf(
                roll1, roll2, roll3, roll4, roll5
        ).thenRun(() -> {
            // 프린트 순서를 확인
            System.out.println("✅ 결과 모두 나옴");

            // join을 통해서 각각의 Future의 결과를 가져오는 것이다.
            Integer int1 = roll1.join();
            Integer int2 = roll2.join();
            Integer int3 = roll3.join();
            Integer int4 = roll4.join();
            Integer int5 = roll5.join();

            String result = IntStream.of(int1, int2, int3, int4, int5)
                    .boxed()
                    .map(i -> i == -1 ? "(무효)" : String.valueOf(i))
                    .collect(Collectors.joining(", "));
            System.out.println("최종 결과 : " + result);
        }).get();
    }

    private static CompletableFuture<Swordman> trainSwordman () {
        return CompletableFuture.supplyAsync(() -> {
            takeTime(new Random().nextBoolean());
            return new Swordman(Side.BLUE);
        }).exceptionally(e -> {
            System.out.println("😭 탈락");
            return null;
        });
    }

    public static void allOfEx2 () throws ExecutionException, InterruptedException {
        ArrayList<CompletableFuture<Swordman>> traings = new ArrayList<>();

        // ForkJoinPool forkJoinPool = new ForkJoinPool(3);

        for (int i = 0; i < 50; i++) {
            traings.add(trainSwordman());
            // traings.add(trainSwordmanWithFJP(forkJoinPool));
            // 각 Future들이 이 풀을 공유하도록 해야한다. ( 각각을 new로 생성해서 넣으면 안된다 )
        }

        // CompletableFuture가 동시에 진행하는 쓰레드의 기본 수
        // - 해당 기기의 가용한 프로세서 수와 같다
        // - 위의 ForkJoinPool 관련 코드 두 줄을 활성화하여 다시 실행해 볼 것이 중요하다
        System.out.println("🖥️ 쓰레드 수 기본: " + ForkJoinPool.getCommonPoolParallelism());

        CompletableFuture.allOf(traings.toArray(CompletableFuture[]::new))
                .thenRun(() -> {
                    long passeds = traings.stream()
                            .map(CompletableFuture::join)
                            .filter(Objects::nonNull)
                            .count();
                    System.out.printf("🎖️ 합격자 : %d명%n", passeds);
                }).get();
    }

    public static CompletableFuture<Swordman> trainSwordmanWithFJP(ForkJoinPool fjp) {
        return CompletableFuture.supplyAsync(() -> {
            takeTime(new Random().nextBoolean());
            return new Swordman(Side.BLUE);
        }, fjp
        ).exceptionally(e -> {
            System.out.println("😭 탈락");
            return null;
        });
    }

    public static CompletableFuture<String> raceRunner(String name, ForkJoinPool fjp) {
        return CompletableFuture.supplyAsync(() -> {
                    takeTime(new Random().nextBoolean());
                    System.out.printf("👟 %s 도착%n", name);
                    return name;
                }, fjp
        ).exceptionally(e -> null);
    }

    public static void anyOfEx () throws ExecutionException, InterruptedException {
        ArrayList<CompletableFuture<String>> runners = new ArrayList<>();

        String[] names = "철수, 영희, 돌준, 병미, 핫훈"
                .split(",");

        // 경쟁할 쓰레드보다 풀 수가 적지 않도록 3으로 변경
        // 앞의 셋 중에서만 나온다
        ForkJoinPool forkJoinPool = new ForkJoinPool(names.length);

        Arrays.stream(names)
                .forEach(r -> runners.add(raceRunner(r, forkJoinPool)));

        // anyOf : 가장 먼저 완료된 결과물을 받아온다
        CompletableFuture.anyOf(
                runners.stream()
                        .toArray(CompletableFuture[]::new)
                )
                .thenAccept(w -> {
                    System.out.println(
                            w != null ? ("🏆 1등: " + w) : "💣 지뢰 폭발"
                    );
                })
                .get();
    }
}
