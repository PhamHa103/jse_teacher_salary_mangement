package constant;

public enum Specialization {
    GS_TS("GS-TS"),
    PGS_TS("PGS-TS"),
    GIANG_VIEN_CHINH("Giảng viên chính"),
    THAC_SY("Thạc sỹ");

    public String value;

    Specialization(String value) {
        this.value = value;
    }
}
