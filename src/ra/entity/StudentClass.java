package ra.entity;

import java.util.Scanner;

public class StudentClass implements IStudentManagement{
    private String  ClassId;
    private String ClassName;
    private String Descriptions;
    private int ClassStatus;

    public StudentClass() {
    }

    public StudentClass(String classId, String className, String descriptions, int classStatus) {
        ClassId = classId;
        ClassName = className;
        Descriptions = descriptions;
        ClassStatus = classStatus;
    }

    public String getClassId() {
        return ClassId;
    }

    public void setClassId(String classId) {
        ClassId = classId;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String descriptions) {
        Descriptions = descriptions;
    }

    public int getClassStatus() {
        return ClassStatus;
    }

    public void setClassStatus(int classStatus) {
        ClassStatus = classStatus;
    }

    @Override
    public void inputData(Scanner sc) {



        System.out.println("nhập vào mã lớp học ");
        do {
            this.ClassId = sc.nextLine();
            if (this.ClassId.length()==5){
                if (this.ClassId.charAt(0)=='J'){
                    break;
                }else {
                    System.err.println("nhập lại mã lớp bắt đầu bằng kí tự 'J'");
                }
            }else {
                System.err.println("nhập lại mã lớp học gồm 5 kí tự");
                }
        }while (true);
        System.out.println("nhập vào tên lớp");
        do {
            this.ClassName=sc.nextLine();
            if (this.ClassName.trim().length()<=10){
                break;
            }else {
                System.err.println(" tên lớp tối đa 10 kí tự");
            }
        }while (true);
        System.out.println("Nhập vào mô tả lớp học");
        this.Descriptions=sc.nextLine();
        System.out.println("nhập vào trạng thái lớp học");
        System.out.println("1 : Sắp bắt đầ " );
        System.out.println("2 : Đang hoạt động " );
        System.out.println("3 : Tạm ngừng hoạt động " );
        this.ClassStatus=Integer.parseInt(sc.nextLine());
        do {
            if (this.ClassStatus>=1 && this.ClassStatus<=3){
               break;
            }else {
                System.out.println("nhập lại số 1-3");
            }

        }while (true);
//


        }





    @Override
    public void displayData() {
        System.out.printf("Mã Lớp :%s- Tên Lớp: %s - Mô Tả: %s - Trạng Thái: %d\n",this.ClassId,this.ClassName,this.Descriptions,this.ClassStatus);

    }
}
