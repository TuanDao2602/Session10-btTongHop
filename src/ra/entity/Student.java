package ra.entity;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student implements IStudentManagement{
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private StudentClass studentClass ;
    private List<Float> listMarkJavaScript =new ArrayList<>();
    private List<Float> listMarkJavaCore = new ArrayList<>();
    private List<Float> listMarkJavaWeb= new ArrayList<>();
    private float avgMark;
    private String gpa;
    private boolean studenstatus;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, boolean sex, StudentClass studentClass, List<Float> listMarkJavaScript, List<Float> listMarkJavaCore, List<Float> listMarkJavaWeb, float avgMark, String gpa, boolean studenstatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.studentClass = studentClass;
        this.listMarkJavaScript = listMarkJavaScript;
        this.listMarkJavaCore = listMarkJavaCore;
        this.listMarkJavaWeb = listMarkJavaWeb;
        this.avgMark = avgMark;
        this.gpa = gpa;
        this.studenstatus = studenstatus;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public List<Float> getListMarkJavaScript() {
        return listMarkJavaScript;
    }

    public void setListMarkJavaScript(List<Float> listMarkJavaScript) {
        this.listMarkJavaScript = listMarkJavaScript;
    }

    public List<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public void setListMarkJavaCore(List<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }

    public List<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaWeb(List<Float> listMarkJavaWeb) {
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public boolean isStudenstatus() {
        return studenstatus;
    }

    public void setStudenstatus(boolean studenstatus) {
        this.studenstatus = studenstatus;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("nhập vào mã sinh viên");
        do {
            this.studentId=sc.nextLine();
            if (this.studentId.trim().length()==6){
                if (this.studentId.trim().charAt(0)=='S'){
                    break;
                }else {
                    System.out.println("nhập lại mã Sinh Viên bắt đầu bằng 'S");
                }
            }else {
                System.out.println("nhập vào mã sinh viên gồm 6 kí tự");
            }

        }while (true);




        System.out.println("nhập vào tên sinh viên");
        do {
        this.studentName=sc.nextLine();

            if (this.studentName.trim().length()>=10 && this.studentName.trim().length()<=20){
                break;

            }else {
                System.out.println("nhập vào tên sinh viên từ -20 kí tự");
            }

        }while (true);


        System.out.println("nhập vào tuổi sinh viên");
        do {
            this.age=Integer.parseInt(sc.nextLine());
            if (this.age>=18){
                break;
            }else {
                System.out.println("nhập lại tuổi sinh viên lớn hơn hoặc bằng 18");
            }

        }while (true);
        System.out.println("Nhập vào giới tính sinh viên");
        this.sex=Boolean.parseBoolean( sc.nextLine());
        int cnt =1;
        System.out.println("nhập vào điểm thi JavaScript ");
        inputMark(listMarkJavaCore,sc);
        System.out.println("nhập vào điểm thi JavaCore ");
        inputMark(listMarkJavaCore,sc);
        System.out.println("nhập vào điểm thi JavaWeb ");
        inputMark(listMarkJavaWeb,sc);
        System.out.println("nhập vào trạng thái sinh viên");
        this.studenstatus= Boolean.parseBoolean(sc.nextLine());





    }
    public static void inputMark(List<Float>listMark ,Scanner sc){
        int cnt=1;
        do {
            System.out.printf("nhập vào điểm thi lần %d\n",cnt);
            listMark.add(Float.parseFloat(sc.nextLine()));
            cnt++;
            System.out.printf("bạn có muốn thêm điểm thi lần %d không:\n",cnt);
            System.out.println("1 : yes ");
            System.out.println("2 : No");
            System.out.println("lựa chọn của bạn là: ");
            int choice =Integer.parseInt(sc.nextLine());
            if (choice !=1){
                break;
            }

        }while (true);

    }

    @Override
    public void displayData() {
        System.out.printf("MÃ SV : %s - Tên SV : %s - Tuổi: %d - GIỚI TÍNH %b - Lớp : %s \n",this.studentId,this.studentName,this.age,this.sex,this.studentClass.getClassName());
        System.out.println("điểm Javascript : ");
        for (Float js_Mark: listMarkJavaScript) {
            System.out.printf("%f\t", js_Mark);
        }
        System.out.println("\n");
        System.out.println("điểm JavaCore : ");
        for (Float js_Mark: listMarkJavaCore) {
            System.out.printf("%f\t", js_Mark);
        }
        System.out.println("\n");
        System.out.println("điểm JavaWeb : ");
        for (Float js_Mark: listMarkJavaWeb) {
            System.out.printf("%f\t", js_Mark);
        }
        System.out.println("\n");
        System.out.printf("điểm TB : %f - xếp loại:%s -Trạng thái: %b\n",this.avgMark,this.gpa,this.studenstatus);

    }
    public void calAvgMark(){
        this.avgMark = (listMarkJavaScript.get(listMarkJavaScript.size()-1) +
                listMarkJavaWeb.get(listMarkJavaWeb.size()-1)
                + listMarkJavaWeb.get(listMarkJavaWeb.size()-1))/3;
    }
    public void getGPA(){
        String studentGPA;
        if (this.avgMark<5){
            studentGPA=" yếu";
        }else if (this.avgMark<7){
            studentGPA="trung bình";
        }else if (this.avgMark<9){
            studentGPA="khá";
        }else {
            studentGPA="giỏi";
        }

    }

}
