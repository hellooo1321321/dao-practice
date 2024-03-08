package run;

import model.dto.ReadDTO;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {


        // main 스위치문 employee == xml ==> 쿼리 , config,common
        // xml 파일
        // DTO ==> 필드에 저장해서 불어 //
        // DAO ==> DAO => 1234 /
        // 1. create   scn 8개                         //          DTO 지향
        // 2. read     emo_id  입력하세요 : 전체가읽     //
        // 3. update   emp_id , 이름 , 민증번호, 급여       //
        // 4. delete   emp_id 선택 전체 행 삭제            //

        // 신규 사원 등록

        Scanner sc = new Scanner(System.in);

        System.out.print("등록할 사원번호(ID)를 입력해주세요 : ");
        String empId = sc.nextLine();
        System.out.print("등록할 사원 이름을 입력해주세요 : ");
        String empName = sc.nextLine();
        System.out.print("등록할 주민등록번호를 입력해주세요(ex. 123456-7891234) : ");
        String empNo = sc.nextLine();
        System.out.print("등록할 e-mail을 입력해주세요 : ");
        String email = sc.nextLine();
        System.out.print("등록할 전화번호를 입력해주세요 : ");
        String phone = sc.nextLine();
        System.out.print("등록할 부서코드를 입력해주세요(ex. D9 : ");
        String deptCode = sc.nextLine();
        System.out.print("등록할 직업코드를 입력해주세요(ex. J1 : ");
        String jobCode = sc.nextLine();
        System.out.print("등록할 급여수준을 입력해주세요(ex. S1 : ");
        String salLevel = sc.nextLine();
        System.out.print("등록할 급여를 입력해주세요 : ");
        int salary = sc.nextInt();
        System.out.print("등록할 보너스를 입력해주세요(ex. 0.3) : ");
        double bonus = sc.nextDouble();
        System.out.print("등록할 관리자Id를 입력해주세요( ex. 200) : ");
        String managerId = sc.nextLine();
        System.out.print("등록할 입사일을 입력해주세요 : ");
        String hireDate = sc.nextLine();
        System.out.print("등록할 가입일을 입력해주세요 : ");
        String entDate = sc.nextLine();
        System.out.print("등록할 입사여부를 입력해주세요('Y' 또는 'N') : ");
        String entYN = sc.nextLine();
    }
//    ReadDTO newEmployee = new ReadDTO(empId, empName, empNo, email, phone, deptCode, jobCode, salLevel, salary, bonus, managerId, hireDate, entDate, entYN);
}
