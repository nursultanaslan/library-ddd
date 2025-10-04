package com.turkcell.library_cqrs.domain.member.model;

public enum MembershipLevel {

    STANDARD,
    GOLD;

    public static MembershipLevel getDefault(){
        return STANDARD;
    }
}
