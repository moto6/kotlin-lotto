# kotlin-lotto

## step1 문자열 덧셈 계산기

## step1 요구사항 정리

### 기능요구사항


- tokenizer
  - 콜론(:)은 구분자로 동작 해야 한다
  - 쉼표(,)는 구분자로 동작 해야 한다
  - 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있어야 한다
  - 커스텀 구분자는 문자열 앞 부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다
  - “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다
  - 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 IllegalArgumentException throw
  - 구분자를 컴마(,) 이외에 콜론(:)을 동시에 사용할 수 있다. (예 : “1,2:3” => 6)
  - "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)

- Validator
  - 빈 문자열 을 입력하는 경우 0 을 반환해야한다
  - null을 입력할 경우 0을 반환해야 한다
  - 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환 해야 한다
  - 숫자 두개를 입력할 경우 두 숫자의 합을 반환 해야 한다

- Token
  - 음수를 전달할 경우 IllegalArgumentException throw

### 프로그래밍 요구 사항
- indent(인덴트, 들여쓰기) depth를 1까지만 허용한다
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다




## 스텝투
- 생각
```text
- 로또 app 은 Stateless 하게
- 용어집
  - Game : 로또번호 6개로 이루어진 하나의 게임
```
```
- LottoNumber(로또번호) : 로또번호 한개, 1~46 의 값을 갖는다 ex) 1, 2, ... 46
- Gaem (게임) : 로또번호 6개로 이루어진, 클라이언트가 구매한 로또 응모권 한장 ex) [3, 5, 11, 16, 32, 38] = 하나의 Game
- Round (회차) : 구매한 모든 로또 게임들의 집합 ex) [3, 5, 11, 16, 32, 38]/ Game 하나, [8, 21, 23, 41, 42, 43]/ Game 둘, ....... Game N개 가 모여서 =>> 하나의 Round

<Round begin>
[Game1 : 8, 21, 23, 41, 42, 43]
   LottoNumber 는 Game 을 구성하는 각각의 숫자들 ex) 8, 21 .. 
Game2 : [3, 5, 11, 16, 32, 38]
Game3 : [7, 11, 16, 35, 36, 44]
<Round end>
```

- 요구사항
- 
```text
## 디자인 내용
- Lotto
  - 구매할 Game 의 수를 입력받아 로또 Game 을 발급해야 한다
  - 구매할 로또 Game 하나의 가격은 1000 이다
  
- Round
  - 당첨번호를 입력하면 당첨자를 집계할수 있어야한다
  
- Game
  - 로또숫자 6개를 하나의 게임으로 묶는 역할
    
## 기능 요구사항 (from mission)
- 로또 구입 금액을 입력하면 >> InputView 에서 담당
- 구입 금액에 해당하는 로또를 발급해야 한다. >> Lotto 에서 담당
- 로또 1장의 가격은 1000원이다. >> Lotto 에서 담당
 
## 프로그래밍 요구사항 / 비기능적 요구사항

- 테스트
  - 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 
- 아키텍쳐  
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 관련
  - UI(System.out, System.in) 로직은 단위테스트가 없어도 괜찮다
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 코드 스타일
  - indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를들어 while문 안에 if문이 있으면 안된다. 왜냐하면 이 경우 들여쓰기는 2이기 때문. indent(들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하기이다.
  - 함수길이제한 : 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - SRP 지키기 : 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
  - 요구사항을 정리하자 : 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
  - 커밋의 단위를 atomic 하게 : git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.


## 여쭤보고싶은 것들

- Game 부분에서 어떻게 Console 창에 하나의 Game 이 표현 되어야 하는지에 대해서 toString() 메서드를 override 해서 구현하였는데, 도메인로직에 ui 가 섞여있다고 생각할수도 있는데, 또 한편으로는 ui 레이어에서 내부 데이터로 접근해서 출력하는것보다 Game 에서 담당하게 하는것도 괜찮아 보여서 어떤 방향이 좀더 적절할지 여쭤보고 싶습니다
- 결국 프로그램이 data + logic 이라는 생각에 도달하게 되어서 data class(데이터를 갖는) + object class (실체화하지 않고, 로직만을 갖는) 두가지로만 코드를 작성하였습니다

     
```


<br><br><br>


## 🚀 3단계 - 로또(2등)

### 3단계의 요구사항을 정리

```text
- 기능 요구사항
2등을 위해 추가 번호를 하나 더 추첨한다.
당첨 통계에 2등도 추가해야 한다.

- 비기능 요구사항
Enum 클래스를 적용해 프로그래밍을 구현한다.
일급 컬렉션을 쓴다.
```



<br><br><br>


## 4단계


### 이전의 피드백 들 중 반영이 되지 않았거나, 애매하거나, 놓친 것들을 리스트업
```text

```
- 같은리뷰 두번 주시게 해서 죄송함다.. 제가 놓쳤슴다 ㅠㅠ (Set.intersect())

### 요구사항

```text

```
