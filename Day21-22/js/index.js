/* --------- 1. var ---------*/
// 전통적인 JS 변수 선언 키워드는 var
// var keyword는 같은 scope내에서 중복 선언 가능

// var x = 100;
// var y = 200;

// var x = 300; // 변수를 재선언하는데 오류가 아님
// var y;       // 이 경우에는 변수 선언이 무시됨

// console.log(x);
// console.log(y);

// var keyword의 가장 큰 특징은 scope가 function level scope임

/* --------- 2. var과 let의 차이점 ---------*/
// let x = 1;

// if(true) {
//     // 이 영역이 block level의 code block
//     // 우리가 알고 있는 다른 언어는 이 block level을 기반으로 scope를 설정함
//     // 그런데 var keyword는 block level로 scope를 설정하지 않음
//     // 아래의 코드는 변수를 재선언하는 방식으로 동작
//     let x = 100;
// }

// console.log(x);
// 만약 block level scope로 동작한다면 1이 출력(블럭 끝나면 날아가기 때문)
// 만약 function level scope로 var이 동작한다면 100이 출력

// var이 아닌 let은 ES6에서 새롭게 등장한 변수선언 키워드임
// let은 block level scope를 가짐

/* --------- 3. const ---------*/

// ES6에서 let과 유사한 const도 변수선언 하기위해 제공
// const는 이름에서 의미하다 시피 변수에 대한 값의 할당을 변경할 수 없음

// const a = 100;
// a = 200; // 변경 불가
// 상수 만들 때 사용


/* --------- 4. Hoisting ---------*/
// console.log(x); // undefined 값이 출력
//                 // 원래 여기서 reference Error가 발생해야 됨
// x = 100;        // 변수 선언이 없는데 변수를 사용했음 이게 가능?

// console.log(x);

// let x;          // 여기에 변수 선언구문이 있음

// JS는 기본적으로 2 phase로 코드가 실행 됨
// 첫번째는 변수(식별자)를 찾는 phase
// 실행코드는 넘어가고 식별자를 선언하는 코드만 실행
// 위 코드에서는 x가 메모리에 만들어지고 undefined라는 값을 이용해서 초기화 진행

// 두번째는 코드를 실행하는 phase => Execution Phase

// 결국 creation phase에서 식별자가 모두 메모레이 올라가는 현상이 일어나고
// 선언이 코드의 아래쪽에서 되었다 하더라도 실제적으로 코드의 제일 위에
// 존재하는 것처럼 동작하게 되는데 이 현상을 Hoisting이라고 함

// 한가지 조심해야 하는 건 let도 역시 hoisting이 일어남
// 하지만 let으로 선언된 변수는 hoisting이 발생해서 변수가 만들어지긴 하지만
// 초기화 구문이 실행되기 전까지는 실제로 사용할 수 없음(TDZ)
// Temperal Dead Zone, 위 코드에서는 처음 나오는 console.log(x)부분

// let myVar = 100;

// {
//     console.log(myVar);
//     let myVar = 200;
// }

// // 코드 블럭단위로 creation phase 와 execution phase가 진행됨
// // 여러가지 요소들이 복합적으로 동작해서 해당 코드는 오류가 발생
// // 오류발생의 이유를 잘 이해해야 함


/* --------- 5. typeof ---------*/
// let myvar1 = 10;
// let myvar2 = 'Hello';
// let myvar3 = true;
// let myvar4;
// let myvar5 = null;

// console.log(typeof myvar1);     //number
// console.log(typeof myvar2);     //string
// console.log(typeof myvar3);     //boolean
// console.log(typeof myvar4);     //undefined
// console.log(typeof myvar5);     //object


/* --------- 6. literal ---------*/
// // javascript의 객체 literal

// var myObj = {
//     // 0개 이상의 property가 나옴
//     name: '홍길동',
//     age: 20,
//     myFunc: function(){
//         // 함수도 값으로 생각
//     },
//     100: 1000,
//     'my-name': '신사임당'
// }

// // key 값은 문자열로 변환 가능한 값을 이용
// // 문자열이 키값이 됨
// // value값은 자바스크립트에서 나오는 모든 값을 사용할 수 있음


/* --------- 7. 객체 만드는 방법 ---------*/
// 1. 객체 literal을 이용해서 객체를 생성
// 2. 생성자 함수(객체를 만들어내는 용도의 함수) => 내가 직접 만든 생성자 함수
// 3. Object 생성자 함수
// 4. Object.create() 메소드를 이용해서 객체 생성
// 5. (ES6에서 도입된) class

// 가장 기초가 되고 많이 사용되는 객체 literal에 대해서 조금만 더 알아볼 것

// let myObj = {
//     name: '홍길동',
//     age: 20,
//     '!name!' : '신사임당', // 키값 강제로 문자열로 만들어서 사용 가능
//     age: 40               // 만약 중복된 property 있으면 마지막 선언된 property로 덮어씀
// }

// // 각각의 property를 access하려면 . 연산자를 이용
// console.log(myObj.name);
// //console.log(myObj.'!name!');  // 당연히 오류
// console.log(myObj['!name!']); // 신사임당
//                               // 배열 형태로도 access 가능
// console.log(myObj['age']);    // 20

// // 만약 property를 동적으로 추가하고 싶으면 어떻게 할까?
// // 새로운 property를 그냥 이용하면 됨 (없으면 추가, 있으면 수정)
// myObj.address = '서울';
// myObj['hobby'] = '운동';


/* --------- 8. ES6에서 추가된 객체 literal의 확장 ---------*/
// ES6에서 추가된 자바스크립트 객체 literal의 표현법(2가지)
// let x = 10;
// let y = 20;

// var myObj = {
//     name: '홍길동',
//     x: x,   // 이렇게 key와 value가 같은 경우에는 하나만 써도 됨
//     y,      // y: y 랑 동일한 의미
//     myFunc: function(){
//         console.log('안녕하세요!');
//     },
//     myFunc() {
//         // 위 함수 표현의 축약표현
//     }
// }


/* --------- 9. primitive type 사용시 주의할 점 ---------*/
// // primitive type : number, string, boolean, undefined, null, Symbol
// // reference type : 객체(object)

// // 참고로 js는 문장끝에 ; 을 안써도 자동으로 삽입됨
// let str = 'hello';

// // 이 문자열을 사용할 때 분명 primitive type인데 이걸 객체처럼 사용할 수 있음
// console.log(str[0]);    // h
// console.log(str.length);    // 5
// console.log(str.toUpperCase()); // HELLO

// str[0] = 'H'
// console.log(str);   // Hello이 아니라 hello 출력

// // primitive type을 객체처럼 사용할 수 없음
// // 만약 primitive type을 객체처럼 사용한다면 wrapper를 이용해서 객체를 별도로 만듦


/* --------- 10. 함수 정의 방법 --------- */
// // 일반적으로 함수를 만들 때 literal을 이용해서 만들 수 있음
// // 함수는 하나의 값이자 객체
// // literal이기 때문에 값임
// // 이 값은 당연히 변수에 저장되어야지 나중에 사용 가능함

// // js에는 함수 리터럴 말고 함수를 만드는 다른 방법이 있음
// // 명시적 함수 선언이라는 방법 따로 있음

// // 아래의 함수는 함수 선언문에 의해서 생성되는 함수
// // 함수 이름 함수 내부에서만 의미 있음
// // 그래서 이 함수를 함수 외부에서 사용하도록 js engine이 함수이름과 똑같은 이름의 변수를 만듦
// function myAdd() {

// }

// // 함수 리터럴과 함수 선언문 어떻게 구분?
// // 일반적으로 리터럴은 묵시적 함수를 사용(함수 이름을 생략)
// // 함수 이름은 함수 내부에서만 사용할 수 있음
// // 함수 외부에서는 add라는 이름 사용할 수 없음
// // 그래서 일반적으로 생략
// var myFunc = function add(x,y){
//     return x+y
// }


/* --------- 11. JS함수 특징 ---------*/
// // JavaScript는 인자의 개수가 맞지 않아도 호출 가능
// // 함수 선언문을 이용해서 선언적 함수 만들기
// function add(x,y) {
//     return x+y;
// }

// console.log(add(10, 20));   // 30
// // 인자수가 모자라도 호출이 될까? => 됨
// console.log(add(10));   // x에 10이 전달되고 y는 undefined가 됨
//                         // NaN(Not a Number)
// console.log(add(10, 20, 30));   // 더 많은 인자 사용할 경우 남는건 버려짐


/* --------- 12. 즉시 실행 함수 ---------*/
// // js는 즉시 실행 함수라는 특이한 형태의 함수를 이용할 수 있음
// // 함수는 선언하고 나중에 필요하면 호출해서 사용하는 구조
// // 그런데 그게 아니라 선언과 동시에 실행하도록 만들 수 있음 => 1회용

// (function add() { // 변수의 scope가 해당 괄호안으로 묶임
//     let x = 10;
//     let y = 20;
//     console.log(x+y);
//     return x+y;
// }())

// // add()   // 호출 안됨

// let x = 10;
// let y = 20;
// console.log(x+y); // 이렇게 쓰면 conflict 날 수 있음

// // javascript 파일 여러개 사용하면 전역공간이 겹치기 때문에 변수명이 동일하다면 conflict가 날 수 있음
// // 해당 라이브러리 제대로 동작하지 않음
// // 이를 해결하기 위해
// // 1) 모듈화 각 js파일를 별도의 scope로 관리
// // 2) 각각의 js 파일 속 변수들의 scope를 한졍 -> 즉시 실행 함수

/* --------- 13. 중첩 함수 ---------*/
// // 중첩함수, 내부함수(nested function, inner function)

// function outer() {
//     let x = 10;

//     // 함수 안의 함수구조를 지원
//     // 이 안의 함수는 helper 함수의 역할을 수행
//     // 외부함수의 바깥에서는 사용할 수 없음
//     function inner(){
//         let y = 20;
//         console.log(x+y);
//     }

//     inner();
// }

// outer();

/* --------- 14. 일급 함수 ---------*/
// 프로그래밍 언어에서 일급객체라는 특수한 형태의 객체가 있음
// first-class object(일급객체)

// 4가지 조건을 만족하면 일급객체
// 1. 변수나 자료구조에 저장이 가능해야 함
// 2. 함수의 인자로 전달될 수 있어야 함
// 3. 리턴값으로 사용될 수 있어야 함
// 4. 런타임(literal)으로 생성할 수 있어야 함

// 자바스크립트의 함수는 당연히 객체임
// 이 함수는 위 4가지 조건을 다 만족함
// 자바스크립트는 일급 함수를 지원
// 자바에서는 메소드를 변수에 저장 불가 -> 일급함수 지원 X


// 프로그래밍하면서 많이 발생하는 경우
// 0부터 내가 원하는 숫자까지 출력하는 단순한 함수 만들기
// function repeat(n){
//     for(let i=0; i<n; i++){
//         console.log(i);
//     }
// }

// // repeat(5);
// // 시간 지난다음 요구사항이 변경됨
// // 위와 거의 같은데 대신 홀수만 출력
// // 기존의 잘 돌아가는 코드는 수정하지 않음
// // 새롭게 다시 만드는게 일반적

// function repeat_odd(n){
//     for(let i=0; i<n; i++){
//         if(i % 2)
//             console.log(i);
//     }
// }

// repeat_odd(9);
// 위처럼 하면 요구사항이 변경될 때마다 계속해서 비슷한 함수가 만들어져야 함


// 일급함수 이용해서 코드 수정
function repeat(n, f) {
    for(let i=0; i<n; i++){
        f(i);
    }
}

let logAll = function(i) {
    console.log(i);
}

let logOdd = function(i) {
    if(i%2)
        console.log(i);
}
// 자바의 디자인패턴 중 Template method랑 비슷

repeat(9, logOdd);