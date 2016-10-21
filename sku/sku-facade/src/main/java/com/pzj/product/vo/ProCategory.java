package com.pzj.product.vo;


public enum ProCategory {
    GANERALTICKET(1,"景点"),
    GRADETICKET(4,"景点"),
    GANCOMCHILDTICKET(5,"景点"),
    COMBINTICKET(11,"景点"),
    GRADECOMCHILDTICKET(12,"景点"),
    ACTCOMCHILDTICKET(13,"演艺"),
    THEATRETICKET(10,"演艺"),
    LINEPRODUCT(1000,"一日游 "),
    SHUTTLEBUS(4001,"新奇"),
    BUSCHARTER(4002,"交通接驳"),
    NATIVEPRODUCT(5000,"特产"),
    TRIPPHOTOS(7000,"旅拍"),
    GUIDEPRODUCT(8000,"导游 "),
    RESTAURANT(9000,"美食"),
    HOTELROOM(9,"住宿");

    
    public static void main(String[] args) {
		String s = "restaurant";
		System.out.println(s.toUpperCase());
	}

    // 成员变量
    private String name;
    private long index;
    // 构造方法
    ProCategory(long index,String name) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(long index) {
        for (ProCategory c : ProCategory.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

}
