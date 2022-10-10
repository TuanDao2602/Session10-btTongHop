package ra.run;

import ra.entity.Student;
import ra.entity.StudentClass;

import java.util.*;

public class StudentManagement {
    static List<StudentClass> listClass = new ArrayList<>();
    static List<Student> listStudent =new ArrayList<Student>();


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        do {
            System.out.println("*************** Quản Lý Học Viện *****************");
            System.out.println(" 1.Quản Lý Lớp");
            System.out.println(" 2.Quản Lý Sinh Viên");
            System.out.println(" 3.Thoát");
            System.out.println("sự lựa chọn của bạn là: ");
            int choice =Integer.parseInt(sc.nextLine());
            switch (choice){

                case 1:
                    StudentManagement.getClassManagement( sc);
                    break;

                case 2:
                    StudentManagement.studentManagement(sc);
                    break;
                case 3:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập vào số 1-3");
            }

        }while (true);


    }
    public static void getClassManagement(Scanner sc){
        boolean exitMenuLopHoc =true;
        do {
            System.out.println("*********Quản Lý Lớp Học ***********");
            System.out.println("1.Thêm Mới Lớp Học");
            System.out.println("2.Cập Nhật Thông Tin Lớp Học");
            System.out.println("3.Hiển Thị Thông Tin Lớp Học");
            System.out.println("4.Thống Kê Lớp Học Đang Hoạt Động");
            System.out.println("5.Tìm Kiếm Lớp Học Theo Tên Lớp");
            System.out.println("6.Thoát");
            System.out.println("Sự lựa chọn của bạn là: ");
            int checkChoiCe =Integer.parseInt(sc.nextLine());

            switch (checkChoiCe){
                case 1:
                    StudentManagement.inputClass(sc);

                    break;
                case 2:
                    StudentManagement.updateClass(sc);

                    break;
                case 3:
                    StudentManagement.displayClas();

                    break;
                case 4:
                    StudentManagement.thongKe();
                    break;
                case 5:
                    StudentManagement.seachClass(sc);

                    break;
                case 6:
                    exitMenuLopHoc = false ;
                    break;
                default:
                    System.err.println("nhập số từ 1-6");
            }

        }while ( exitMenuLopHoc);


    }
    public static void studentManagement(Scanner sc){
        boolean exitMenuSinhVien =true;
        do {
            System.out.println("*******Quản Lý Sinh Viên*******");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Cập nhật thông tin sinh viên");
            System.out.println("3. Hiển thị thông tin sinh viên");
            System.out.println("4. Tính điểm trung bình");
            System.out.println("5. Xếp loại sinh viên");
            System.out.println(" 6. Sắp xếp sinh viên theo điểm trung bình tăng dần");
            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8. Thống kê số sinh viên đạt loại giỏi, khá, trung bình và yếu");
            System.out.println(" 9. Thống kê các sinh viên Pass qua các môn học");
            System.out.println("10.Thoát");
            System.out.println("Sự lựa chọn của bạn là: ");
            int choice2=Integer.parseInt(sc.nextLine());
            switch (choice2){
                case 1:
                    StudentManagement.inputListStudent(sc);
                    break;
                case 2:
                    StudentManagement.updateStudent(sc);

                    break;
                case 3:
                    StudentManagement.showListStudent();
                    break;
                case 4:
                    StudentManagement.avgMarkStudent();
                    break;
                case 5:
                    StudentManagement.gpaStudent();
                    break;
                case 6:
                    StudentManagement.sortAvgStudent();
                    break;
                case 7:
                    StudentManagement.seachStudent(sc);
                    break;
                case 8:
                    StudentManagement.thongKeGpa();
                    break;
                case 9:
                    StudentManagement.showListPass();
                    break;
                case 10:
                    exitMenuSinhVien = false;
                    break;

                default:
                    System.err.println("nhập vào số từ 1-10");
            }

        }while (exitMenuSinhVien);
    }



    //case1 : nhập thông tin lớp
    public static void inputClass(Scanner sc){
        System.out.printf("nhập số lớp học cần thêm");
        int slLopHoc=Integer.parseInt(sc.nextLine());
        for (int i = 0; i < slLopHoc; i++) {
            System.out.println("thông tin lớp học  thứ "+(i+1));
            StudentClass studentClass =new StudentClass();
            studentClass.inputData(sc);
            listClass.add(studentClass);
        }
    }

    // case 2: câ nhật thông tin
    public static void updateClass(Scanner sc){
        System.out.println("nhập vào mã lớp học cần cập nhật thông tin");
        String inputId = sc.nextLine();
        int indexUpdateClass = -1;
        for (int i = 0; i < listClass.size(); i++) {
            if (listClass.get(i).getClassId().equals(inputId)){
                indexUpdateClass=i;
                break;

            }

        }
        if (indexUpdateClass!=-1){
            System.out.println("Nhập tên lớp");
            String updateClassName =sc.nextLine();
            if (updateClassName!=""&& updateClassName.length()<=10 ){
                listClass.get(indexUpdateClass).setClassName(updateClassName);
            }
            else {
                System.out.println("mời nhập lại tên lớp tối đa 10 kí tự");
            }
            System.out.println("nhập vào mô tả của lớp học");
            String updateDescriptions =sc.nextLine();
            if (updateDescriptions!=""&& updateDescriptions.length()!=0){
                listClass.get(indexUpdateClass).setDescriptions(updateDescriptions);
            }
//            else {
//                System.out.println("mời nhập lại");
//            }
            System.out.println("nhập vào trạng thái lớp học");
            int updateClassStatus =Integer.parseInt(sc.nextLine());
            if (updateClassStatus>=1 && updateClassStatus<=3){
                listClass.get(indexUpdateClass).setClassStatus(updateClassStatus);
            }else {
                System.out.println("nhập lại từ 1-3");
            }
        }else {
            System.out.println("lớp không tồn tại");
        }

    }
    //case3: in ra thông tin class
    public static void displayClas(){
       for (int i = 0; i < listClass.size(); i++) {
        System.out.println("thông tin lớp học: "+(i+1));
        listClass.get(i).displayData();
    }
    //
//                    for (StudentClass xclass:listClass) {
//                        xclass.displayData();
//
//                    }

    }

    //case4:thông kê lớp đang hoạt động;
    public static void thongKe(){
        int count =0;
        for (int i = 0; i < listClass.size(); i++) {
            if (listClass.get(i).getClassStatus() == 2){
                listClass.get(i).displayData();
                count++;

            }

        }
        System.out.printf("có %d Lớp học đang hoạt động ",count);
        System.out.println("\n");

    }

    //case5 tìm kiếm theo tên lớp học
    //dùng equals(chính xác) hoặc contains.(gần đúng)
    public static void seachClass(Scanner sc) {
        System.out.println("nhập vào tên lớp cần tìm");
        String classSeach = sc.nextLine();
        for (int i = 0; i < listClass.size(); i++) {

            if (listClass.get(i).getClassName().equals(classSeach)){
                listClass.get(i).displayData();
            }
            else {
                System.out.printf("class %s bạn tìm ko có \n", classSeach);
            }
        }
    }

//    CASE 2 Lớn
public static void inputListStudent(Scanner sc) {
    System.out.println("nhập vào số sinh viên cần nhập thông tin");
    int cnt = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < cnt; i++) {
        Student studentNew = new Student();
        studentNew.inputData(sc);
        System.out.println("chọn lớp học cho sinh viên");
        int index = 1;
        for (StudentClass stclass : listClass) {
            System.out.printf("%d.%sư\n", index, stclass.getClassName());
            index++;

            }
        System.out.printf("sự lựa chọn của bạn");
        int choice = Integer.parseInt(sc.nextLine());
        //gán vào cho thuộc tính studentClass của đối tượng studentNew
        studentNew.setStudentClass(listClass.get(choice - 1));
        //add vào listStudent
        listStudent.add(studentNew);// THẤY LỖI

        }
    }
    //case2: cập nhật thông tin sinh viên
    public static void updateStudent(Scanner sc){
        System.out.println("nhập vào mã sinh viên cần cập nhật thông tin");
        String studentIdUpdate = sc.nextLine();
        for (Student student: listStudent) {
            if (student.getStudentId().equals(studentIdUpdate)){
                System.out.println("nhập vào tên sinh viên cần cập nhật");
                String studentName = "";
                do {
                    studentName=sc.nextLine();
                    if (studentName !=""&&studentName.length()!=0){
                        if (studentName.length()>=6 && studentName.length()<=50){
                            student.setStudentName(studentName);
                            break;
                        }else {
                            System.err.println("nhập vào tên sinh viên từ 6-50 kí tự");
                        }
                    }

                }while (true);
            }
            System.out.println("nhập vào tuổi sinh viên cần cập nhật");
            String age="";
            do {
                age=sc.nextLine();
                if (age!="" && age.length() !=0){
                    if (Integer.parseInt(age)>=18){
                        student.setAge(Integer.parseInt(age));
                        break;
                    }
                }else {
                    System.out.println("vui lòng nhập lại tuổi sinh viên lớn hơn hoặc bằng 18");
                }

            }while (true);

            System.out.println("nhập vào giới tính sinh viên cần cập nhật");
            String sex = sc.nextLine();
            if (sex !="" && sex.length() != 0){
                student.setSex(Boolean.parseBoolean(sex));
            }
            System.out.println("chọn lớp cho sinh viên");
            int cntClass=1;
            for (StudentClass studentClass:listClass) {
                System.out.printf("%d.%s\n",cntClass,studentClass.getClassName());
                cntClass++;
            }
            System.out.printf("%d không cập nhật lớp\n",cntClass);
            System.out.println("sự lựa chọn của bạn là");
            int choice =Integer.parseInt(sc.nextLine());
            if (choice!= cntClass){
                student.setStudentClass(listClass.get(choice-1));
            }

            //cập nhật điểm cho sinh viên;
            StudentManagement.updateStudentMark(student.getListMarkJavaScript(), sc, student, "JavaScript");
            StudentManagement.updateStudentMark(student.getListMarkJavaCore(), sc, student, "JavaCore");
            StudentManagement.updateStudentMark(student.getListMarkJavaWeb(), sc, student, "JavaWeb");
            //Tinh lai diem trung binh cho sinh vien
            student.getAvgMark();
            //Xep loai lai cho sinh vien
            student.getGPA();
            //Cap nhat trang thai sinh vien
            System.out.println("Nhap vao trang thai sinh vien can cap nhat: ");
            String studentStatus = sc.nextLine();
            if (studentStatus != "" && studentStatus.length() != 0) {
                student.setStudenstatus(Boolean.parseBoolean(studentStatus));
            }
        }
//        if ()
    }
    public static void updateStudentMark(List<Float> listMark, Scanner sc, Student student, String subject) {
        System.out.printf("Cap nhat diem %s cho sinh vien: \n", subject);
        System.out.println("1. Nhap moi diem cho sinh vien");
        System.out.println("2. Them moi diem cho sinh vien");
        System.out.println("3. Cap nhat 1 diem trong danh sach");
        System.out.println("4. Khong cap nhat");
        System.out.print("Lua chon cua ban: ");
        int choiceJS = Integer.parseInt(sc.nextLine());
        switch (choiceJS) {
            case 1:
                List<Float> listJS = new ArrayList<>();
                Student.inputMark(listJS, sc);
                student.setListMarkJavaScript(listJS);
                break;
            case 2:
                Student.inputMark(student.getListMarkJavaScript(), sc);
                break;
            case 3:
                System.out.println("Nhap vao lan thi muon cap nhat: ");
                int examTimes = Integer.parseInt(sc.nextLine());
                System.out.println("Nhap vao diem thi cap nhat:");
                float mark = Float.parseFloat(sc.nextLine());
                //Cap nhat
                student.getListMarkJavaScript().set(examTimes - 1, mark);
                break;
        }
    }


    // case3 :in thông tin sinh viên
    public static void showListStudent(){
        for (int i = 0; i < listStudent.size(); i++) {
            listStudent.get(i).displayData();

        }
    }
    // case 4 :tính điểm trung bình
    public static void avgMarkStudent(){
        for (int i = 0; i < listStudent.size(); i++) {
            listStudent.get(i).calAvgMark();

        }
        System.out.println("đã tính điểm trung bình");
    }
    //case 5 : xếp loại học sinh
    public static void gpaStudent(){
        for (int i = 0; i < listStudent.size(); i++) {
            listStudent.get(i).getGPA();

        }
        System.out.println("đã xếp loại học sinh");
    }
//    case 6: sắp xếp sinh viên theo điểm trung bình tăng dần
    public static void sortAvgStudent() {
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAvgMark() > o2.getAvgMark()) {
                    return 1;
                } else if (o1.getAvgMark() == o2.getAvgMark()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }
//    case 7 tìm kiếm sinh viên theo tên sinh viên
    public static void seachStudent(Scanner sc){
        System.out.println("nhập vào tên sinh viên cần tìm");
        String stdSeach = sc.nextLine();
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getStudentName().equals(stdSeach)){
                listStudent.get(i).displayData();
            }

        }
    }
    //case8 : thống kê khá giỏi
    public static void thongKeGpa(){
        int hsYeu=0;
        int hsTB =0;
        int hsKha=0;
        int hsGioi=0;
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getAvgMark()<5 ){
                hsYeu++;
            }else if (listStudent.get(i).getAvgMark()<7 ){
                hsTB++;
            }else if ((listStudent.get(i).getAvgMark()<9)){
                hsKha++;
            }else {
                hsGioi++;
            }

        }
        System.out.printf("số lượng học sinh yếu là : %d - học sinh Trung bình là: %d - Học sinh khá là : %d - học sinh giỏi là : %d",hsYeu,hsTB,hsKha,hsGioi);
        System.out.println("\n");
    }

//    case9 học sinh qua môn
        public static void showListPass() {
            int count = 0;
            for (int i = 0; i < listStudent.size(); i++) {
                if (listStudent.get(i).getAvgMark() > 5){
                    count++;
                    listStudent.get(i).displayData();

                }
            }
            System.out.printf("Có %d học sinh đã đỗ.", count);
            System.out.println("\n");

        }

}

