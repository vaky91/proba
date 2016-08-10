package org.infobip.campus.dependencies;

/**
 * Created by hbusic on 10.8.2016.
 */
public class Member {

    private String number;

    public Member(String number) {
        if(number == null) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if(number == null) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return number != null ? number.equals(member.number) : member.number == null;

    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }
}
