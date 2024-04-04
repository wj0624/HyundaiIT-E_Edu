package workshop07;

class Point {
	int x, y;
	public Point() {
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

abstract class Shape{
	Point point;
	
	public Shape() {
	}
	
	public Shape(Point point) {
		this.point = point;
	}
	
	public abstract double getArea();
	public abstract double getCircumference();

	public abstract String printInfo();
}

interface Movable {
	void move(int x, int y);
}

class Circle extends Shape implements Movable{
	int radius;
	public Circle() {

	}
	
	public Circle(int radius, int x, int y) {
		super();
		this.radius = radius;
		this.point = new Point(x, y);
	}

	@Override
	public void move(int x, int y) {
		this.point.x += x+1;
		this.point.y += y+1;
	}

	@Override
	public double getArea() {
		return radius*radius*3.14;
	}

	@Override
	public double getCircumference() {
		// TODO Auto-generated method stub
		return 2*3.14*radius;
	}
	
	public String printInfo() {
		return "Cicle: "+this.radius+" "+this.point.x+" "+this.point.y;
	}
}

class Rectangle extends Shape implements Movable{
	int width;
	public Rectangle() {

	}
	
	public Rectangle(int width, int x, int y) {
		super();
		this.width = width;
		this.point = new Point(x, y);
	}

	@Override
	public void move(int x, int y) {
		this.point.x += x+2;
		this.point.y += y+2;
	}

	@Override
	public double getArea() {
		return width*width;
	}

	@Override
	public double getCircumference() {
		// TODO Auto-generated method stub
		return width*4;
	}
	
	public String printInfo() {
		return "Rectangle: "+this.width+" "+this.point.x+" "+this.point.y;
	}
}

public class Test01 {

	public static void main(String[] args) {
		Shape shape[] = new Shape[4];
		// (1.조건)에서 주어진 데이터를 기반으로 Shape type의 객체를 생성 하여
		// 4개의 도형 객체를 배열에 넣는다.
		shape[0] = new Rectangle(4, 7, 5);
		shape[1] = new Rectangle(5, 4, 6);
		shape[2] = new Circle(6, 6, 7);
		shape[3] = new Circle(7, 8, 3);
		// 모든 객체의 for Loop를 이용하여 화면에 출력 한다
		for(Shape sh : shape) {
			System.out.println(sh.printInfo());
		}
		
		// 모든 객체들을 for Loop문을 이용하여 move()함수를 이용하여
		// x가 10증가, y가 10증가 되도록 변경 한 후 객체 정보를 화면에 출력 한다
		System.out.println("After Move ..............");
		for(Shape sh : shape) {
			((Movable) sh).move(10, 10);
			System.out.println(sh.printInfo());
		}
	}

}
