package org.example.procject;


import java.text.DecimalFormat;
import java.util.Scanner;

public class main {
    private static Account[] accountArray = new Account[100];
    private static Scanner sc = new Scanner(System.in);
    private static final String PREFIX = "Bank-";
    private static int seq = 0;
    private static boolean isCreated = false;

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("=====================================");
            System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
            System.out.println("=====================================");
            System.out.println("선택");

            int selectNo = sc.nextInt();
            switch (selectNo) {
                case 1: creatAccount();
                    break;
                case 2: accountList();
                    break;
                case 3: deposit();
                    break;
                case 4: withdraw();
                    break;
                case 5: run = false;
                    break;
            }
        }
        System.out.println("프로그램 종료");
    }
    private static void withdraw() {
        if (!isRegistered()) {
            System.out.println("먼저 계좌등록을 하세요.");
            return;
        }
        accountList();
        System.out.println("출금할 계좌번호를 선택하세요");
        Account account;
        while (true) {
            String ano = sc.next();
            account = findAccount(ano);
            if (account == null)
                System.out.println("계좌번호를 확인하세요.");
            else
                break;

        }
        System.out.println("출금할 금액을 입력하세요.");
        int amount = sc.nextInt();
        int result;

        try {
            result = account.withdraw(amount);
            System.out.println("출금액 : " + result);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deposit() {
        if(!isRegistered()) {
            System.out.println("먼저 계좌등록을 하세요.");
            return;
        }
        accountList();
        System.out.println("입급할 계좌번호를 선택하세요.");
        Account account;
        while (true) {
            String ano = sc.next();
            account = findAccount(ano);
            if (account == null)
                System.out.println("계좌번호를 확인하세요.");
            else
                break;
        }
        System.out.println("입금할 금액을 입력하세요.");
        int amount = sc.nextInt();
        account.deposit(amount);
        System.out.println("예금 성공");
    }
    private static void accountList() {
        if(!isRegistered()) {
            System.out.println("먼저 계좌등록을 하세요.");
            return;
        }
        for(int i = 0; i < accountArray.length; i++) {
            if(accountArray[i]!= null) {
                System.out.println(accountArray[i].getAno()+accountArray[i].getOwner()+accountArray[i].getBalance());
            }
        }
    }
    private static void creatAccount() {
        String ano = PREFIX + String.format(new DecimalFormat("0000").format(seq++));
        System.out.println("소유주명");
        String owner = sc.next();
        System.out.print("초기입금액");

        int amount = sc.nextInt();
        for(int i = 0; i < accountArray.length; i++) {
            if(accountArray[i] == null) {
                accountArray[i] = new Account(ano,owner,amount);
                System.out.println("계좌 등록 성공");
                isCreated = true;
                break;
            }
        }
    }
    private static boolean isRegistered() {
        return isCreated;
    }
    private static Account findAccount(String ano) {
        Account account = null;
        for(int i = 0; i < accountArray.length; i++) {
            if(accountArray[i]!=null)
                if(accountArray[i].getAno().equals(ano)){
                    account = accountArray[i];
                }
        }
        return account;
    }
}