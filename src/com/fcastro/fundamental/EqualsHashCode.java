package com.fcastro.fundamental;

import java.sql.SQLOutput;

public class EqualsHashCode {

    static class Money{
        int amount;
        String currencyCode;

        public Money(int amount, String currencyCode) {
            this.amount = amount;
            this.currencyCode = currencyCode;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof Money))
                return false;
            Money other = (Money)o;
            boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
                    || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
            return this.amount == other.amount && currencyCodeEquals;
        }
    }

    static class WrongVoucher extends Money {

        private String store;

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof WrongVoucher))
                return false;
            WrongVoucher other = (WrongVoucher)o;
            boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
                    || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
            boolean storeEquals = (this.store == null && other.store == null)
                    || (this.store != null && this.store.equals(other.store));
            return this.amount == other.amount && currencyCodeEquals && storeEquals;
        }

        public WrongVoucher(int amount, String currencyCode, String store) {
            super(amount, currencyCode);
            this.store = store;
        }
    }

    static class Voucher {

        private Money value;
        private String store;

        Voucher(int amount, String currencyCode, String store) {
            this.value = new Money(amount, currencyCode);
            this.store = store;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof Voucher))
                return false;
            Voucher other = (Voucher) o;
            boolean valueEquals = (this.value == null && other.value == null)
                    || (this.value != null && this.value.equals(other.value));
            boolean storeEquals = (this.store == null && other.store == null)
                    || (this.store != null && this.store.equals(other.store));
            return valueEquals && storeEquals;
        }
    }

    public static void main(String[] args){
        Money income = new Money(55, "USD");
        Money expenses = new Money(55, "USD");
        boolean balanced = income.equals(expenses);
        System.out.println("Money equals Money (expect true)? " + balanced);
        System.out.println();

        System.out.println("----- Violating Equals Symmetry with Inheritance");
        Money cash = new Money(42, "USD");
        WrongVoucher wrongVoucher = new WrongVoucher(42, "USD", "Amazon");

        boolean isEqualsWrongVoucherCash = wrongVoucher.equals(cash);
        boolean isEqualsCashWrongVoucher = cash.equals(wrongVoucher);
        System.out.println("Voucher equals Cash (expect false)? "+ isEqualsWrongVoucherCash);
        System.out.println("Cash equals Voucher (expect false)? "+ isEqualsCashWrongVoucher);

        System.out.println();
        System.out.println("----- Fixing Symmetry with Composition");
        Voucher voucher = new Voucher(42, "USD", "Amazon");

        boolean isEqualsVoucherCash = voucher.equals(cash);
        boolean isEqualsCashVoucher = cash.equals(voucher);
        System.out.println("Voucher equals Cash (expect false)? "+ isEqualsVoucherCash);
        System.out.println("Cash equals Voucher (expect false)? "+ isEqualsCashVoucher);

    }
}
