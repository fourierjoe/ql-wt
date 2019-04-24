package yhao.micro.service.surety.business.service;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @Description:
 * @Created by ql on 2019/2/26 16:58
 * @Version: v1.0
 */
public class Test {
	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal(0);
		ArrayList<BigDecimal> list1 = Lists.newArrayList();
		list1.add(new BigDecimal(1));
		list1.add(new BigDecimal(3));
		ArrayList<A> list = Lists.newArrayList();
		list.add(new A(new BigDecimal(1)));
		list.add(new A(new BigDecimal(2)));
//		list.forEach(a -> {
//			bigDecimal.add(a.getI());
//		});
		list1.forEach(list3 -> bigDecimal.add(list3));
		System.out.println(bigDecimal);
		BigDecimal b = list1.stream().reduce(BigDecimal::add).get();
		System.out.println(b);
		BigDecimal bigDecimal1 = list.stream().map(A::getI).reduce(BigDecimal::add).get();
		System.out.println(bigDecimal1);

		Student student = new Student();
		System.out.println(student);
//		Student student1 = Optional.ofNullable(student).orElseGet(() -> Student.createStudent());
		Student student1 = Optional.ofNullable(student).orElse(Student.createStudent());
		System.out.println("student=" + student1);
	}
}

class A {
	private BigDecimal i;
	A(BigDecimal bigDecimal) {
		this.i = bigDecimal;
	}
	public BigDecimal getI() {
		return i;
	}

	public void setI(BigDecimal i) {
		this.i = i;
	}
}

class Student {
	private String name;

	Student() {
		this.name = "345";
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public static Student createStudent() {
		Student student = new Student();
		student.setName("123");
		return student;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				'}';
	}
}
