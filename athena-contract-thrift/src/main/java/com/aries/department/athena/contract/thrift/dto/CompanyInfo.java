/**
 * Autogenerated by Thrift Compiler (0.12.0)
 * <p>
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
package com.aries.department.athena.contract.thrift.dto;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-05-31")
public class CompanyInfo implements org.apache.thrift.TBase<CompanyInfo, CompanyInfo._Fields>, java.io.Serializable, Cloneable, Comparable<CompanyInfo> {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CompanyInfo");

    private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short) 1);
    private static final org.apache.thrift.protocol.TField PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("password", org.apache.thrift.protocol.TType.STRING, (short) 2);
    private static final org.apache.thrift.protocol.TField KEYWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("keyword", org.apache.thrift.protocol.TType.STRING, (short) 3);

    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new CompanyInfoStandardSchemeFactory();
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new CompanyInfoTupleSchemeFactory();

    public @org.apache.thrift.annotation.Nullable
    java.lang.String name; // required
    public @org.apache.thrift.annotation.Nullable
    java.lang.String password; // required
    public @org.apache.thrift.annotation.Nullable
    java.lang.String keyword; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        NAME((short) 1, "name"),
        PASSWORD((short) 2, "password"),
        KEYWORD((short) 3, "keyword");

        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

        static {
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                byName.put(field.getFieldName(), field);
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, or null if its not found.
         */
        @org.apache.thrift.annotation.Nullable
        public static _Fields findByThriftId(int fieldId) {
            switch (fieldId) {
                case 1: // NAME
                    return NAME;
                case 2: // PASSWORD
                    return PASSWORD;
                case 3: // KEYWORD
                    return KEYWORD;
                default:
                    return null;
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, throwing an exception
         * if it is not found.
         */
        public static _Fields findByThriftIdOrThrow(int fieldId) {
            _Fields fields = findByThriftId(fieldId);
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            return fields;
        }

        /**
         * Find the _Fields constant that matches name, or null if its not found.
         */
        @org.apache.thrift.annotation.Nullable
        public static _Fields findByName(java.lang.String name) {
            return byName.get(name);
        }

        private final short _thriftId;
        private final java.lang.String _fieldName;

        _Fields(short thriftId, java.lang.String fieldName) {
            _thriftId = thriftId;
            _fieldName = fieldName;
        }

        public short getThriftFieldId() {
            return _thriftId;
        }

        public java.lang.String getFieldName() {
            return _fieldName;
        }
    }

    // isset id assignments
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;

    static {
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        tmpMap.put(_Fields.PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("password", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        tmpMap.put(_Fields.KEYWORD, new org.apache.thrift.meta_data.FieldMetaData("keyword", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CompanyInfo.class, metaDataMap);
    }

    public CompanyInfo() {
    }

    public CompanyInfo(
            java.lang.String name,
            java.lang.String password,
            java.lang.String keyword) {
        this();
        this.name = name;
        this.password = password;
        this.keyword = keyword;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public CompanyInfo(CompanyInfo other) {
        if (other.isSetName()) {
            this.name = other.name;
        }
        if (other.isSetPassword()) {
            this.password = other.password;
        }
        if (other.isSetKeyword()) {
            this.keyword = other.keyword;
        }
    }

    public CompanyInfo deepCopy() {
        return new CompanyInfo(this);
    }

    @Override
    public void clear() {
        this.name = null;
        this.password = null;
        this.keyword = null;
    }

    @org.apache.thrift.annotation.Nullable
    public java.lang.String getName() {
        return this.name;
    }

    public CompanyInfo setName(@org.apache.thrift.annotation.Nullable java.lang.String name) {
        this.name = name;
        return this;
    }

    public void unsetName() {
        this.name = null;
    }

    /** Returns true if field name is set (has been assigned a value) and false otherwise */
    public boolean isSetName() {
        return this.name != null;
    }

    public void setNameIsSet(boolean value) {
        if (!value) {
            this.name = null;
        }
    }

    @org.apache.thrift.annotation.Nullable
    public java.lang.String getPassword() {
        return this.password;
    }

    public CompanyInfo setPassword(@org.apache.thrift.annotation.Nullable java.lang.String password) {
        this.password = password;
        return this;
    }

    public void unsetPassword() {
        this.password = null;
    }

    /** Returns true if field password is set (has been assigned a value) and false otherwise */
    public boolean isSetPassword() {
        return this.password != null;
    }

    public void setPasswordIsSet(boolean value) {
        if (!value) {
            this.password = null;
        }
    }

    @org.apache.thrift.annotation.Nullable
    public java.lang.String getKeyword() {
        return this.keyword;
    }

    public CompanyInfo setKeyword(@org.apache.thrift.annotation.Nullable java.lang.String keyword) {
        this.keyword = keyword;
        return this;
    }

    public void unsetKeyword() {
        this.keyword = null;
    }

    /** Returns true if field keyword is set (has been assigned a value) and false otherwise */
    public boolean isSetKeyword() {
        return this.keyword != null;
    }

    public void setKeywordIsSet(boolean value) {
        if (!value) {
            this.keyword = null;
        }
    }

    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        switch (field) {
            case NAME:
                if (value == null) {
                    unsetName();
                } else {
                    setName((java.lang.String) value);
                }
                break;

            case PASSWORD:
                if (value == null) {
                    unsetPassword();
                } else {
                    setPassword((java.lang.String) value);
                }
                break;

            case KEYWORD:
                if (value == null) {
                    unsetKeyword();
                } else {
                    setKeyword((java.lang.String) value);
                }
                break;

        }
    }

    @org.apache.thrift.annotation.Nullable
    public java.lang.Object getFieldValue(_Fields field) {
        switch (field) {
            case NAME:
                return getName();

            case PASSWORD:
                return getPassword();

            case KEYWORD:
                return getKeyword();

        }
        throw new java.lang.IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
        if (field == null) {
            throw new java.lang.IllegalArgumentException();
        }

        switch (field) {
            case NAME:
                return isSetName();
            case PASSWORD:
                return isSetPassword();
            case KEYWORD:
                return isSetKeyword();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override
    public boolean equals(java.lang.Object that) {
        if (that == null)
            return false;
        if (that instanceof CompanyInfo)
            return this.equals((CompanyInfo) that);
        return false;
    }

    public boolean equals(CompanyInfo that) {
        if (that == null)
            return false;
        if (this == that)
            return true;

        boolean this_present_name = true && this.isSetName();
        boolean that_present_name = true && that.isSetName();
        if (this_present_name || that_present_name) {
            if (!(this_present_name && that_present_name))
                return false;
            if (!this.name.equals(that.name))
                return false;
        }

        boolean this_present_password = true && this.isSetPassword();
        boolean that_present_password = true && that.isSetPassword();
        if (this_present_password || that_present_password) {
            if (!(this_present_password && that_present_password))
                return false;
            if (!this.password.equals(that.password))
                return false;
        }

        boolean this_present_keyword = true && this.isSetKeyword();
        boolean that_present_keyword = true && that.isSetKeyword();
        if (this_present_keyword || that_present_keyword) {
            if (!(this_present_keyword && that_present_keyword))
                return false;
            if (!this.keyword.equals(that.keyword))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode = hashCode * 8191 + ((isSetName()) ? 131071 : 524287);
        if (isSetName())
            hashCode = hashCode * 8191 + name.hashCode();

        hashCode = hashCode * 8191 + ((isSetPassword()) ? 131071 : 524287);
        if (isSetPassword())
            hashCode = hashCode * 8191 + password.hashCode();

        hashCode = hashCode * 8191 + ((isSetKeyword()) ? 131071 : 524287);
        if (isSetKeyword())
            hashCode = hashCode * 8191 + keyword.hashCode();

        return hashCode;
    }

    @Override
    public int compareTo(CompanyInfo other) {
        if (!getClass().equals(other.getClass())) {
            return getClass().getName().compareTo(other.getClass().getName());
        }

        int lastComparison = 0;

        lastComparison = java.lang.Boolean.valueOf(isSetName()).compareTo(other.isSetName());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetName()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = java.lang.Boolean.valueOf(isSetPassword()).compareTo(other.isSetPassword());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetPassword()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.password, other.password);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = java.lang.Boolean.valueOf(isSetKeyword()).compareTo(other.isSetKeyword());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetKeyword()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.keyword, other.keyword);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        return 0;
    }

    @org.apache.thrift.annotation.Nullable
    public _Fields fieldForId(int fieldId) {
        return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        scheme(iprot).read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        scheme(oprot).write(oprot, this);
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("CompanyInfo(");
        boolean first = true;

        sb.append("name:");
        if (this.name == null) {
            sb.append("null");
        } else {
            sb.append(this.name);
        }
        first = false;
        if (!first) sb.append(", ");
        sb.append("password:");
        if (this.password == null) {
            sb.append("null");
        } else {
            sb.append(this.password);
        }
        first = false;
        if (!first) sb.append(", ");
        sb.append("keyword:");
        if (this.keyword == null) {
            sb.append("null");
        } else {
            sb.append(this.keyword);
        }
        first = false;
        sb.append(")");
        return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
        // check for required fields
        // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        try {
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        } catch (org.apache.thrift.TException te) {
            throw new java.io.IOException(te);
        }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        try {
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        } catch (org.apache.thrift.TException te) {
            throw new java.io.IOException(te);
        }
    }

    private static class CompanyInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        public CompanyInfoStandardScheme getScheme() {
            return new CompanyInfoStandardScheme();
        }
    }

    private static class CompanyInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<CompanyInfo> {

        public void read(org.apache.thrift.protocol.TProtocol iprot, CompanyInfo struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();
            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }
                switch (schemeField.id) {
                    case 1: // NAME
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.name = iprot.readString();
                            struct.setNameIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 2: // PASSWORD
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.password = iprot.readString();
                            struct.setPasswordIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 3: // KEYWORD
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.keyword = iprot.readString();
                            struct.setKeywordIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    default:
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            // check for required fields of primitive type, which can't be checked in the validate method
            struct.validate();
        }

        public void write(org.apache.thrift.protocol.TProtocol oprot, CompanyInfo struct) throws org.apache.thrift.TException {
            struct.validate();

            oprot.writeStructBegin(STRUCT_DESC);
            if (struct.name != null) {
                oprot.writeFieldBegin(NAME_FIELD_DESC);
                oprot.writeString(struct.name);
                oprot.writeFieldEnd();
            }
            if (struct.password != null) {
                oprot.writeFieldBegin(PASSWORD_FIELD_DESC);
                oprot.writeString(struct.password);
                oprot.writeFieldEnd();
            }
            if (struct.keyword != null) {
                oprot.writeFieldBegin(KEYWORD_FIELD_DESC);
                oprot.writeString(struct.keyword);
                oprot.writeFieldEnd();
            }
            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

    }

    private static class CompanyInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        public CompanyInfoTupleScheme getScheme() {
            return new CompanyInfoTupleScheme();
        }
    }

    private static class CompanyInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<CompanyInfo> {

        @Override
        public void write(org.apache.thrift.protocol.TProtocol prot, CompanyInfo struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            java.util.BitSet optionals = new java.util.BitSet();
            if (struct.isSetName()) {
                optionals.set(0);
            }
            if (struct.isSetPassword()) {
                optionals.set(1);
            }
            if (struct.isSetKeyword()) {
                optionals.set(2);
            }
            oprot.writeBitSet(optionals, 3);
            if (struct.isSetName()) {
                oprot.writeString(struct.name);
            }
            if (struct.isSetPassword()) {
                oprot.writeString(struct.password);
            }
            if (struct.isSetKeyword()) {
                oprot.writeString(struct.keyword);
            }
        }

        @Override
        public void read(org.apache.thrift.protocol.TProtocol prot, CompanyInfo struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            java.util.BitSet incoming = iprot.readBitSet(3);
            if (incoming.get(0)) {
                struct.name = iprot.readString();
                struct.setNameIsSet(true);
            }
            if (incoming.get(1)) {
                struct.password = iprot.readString();
                struct.setPasswordIsSet(true);
            }
            if (incoming.get(2)) {
                struct.keyword = iprot.readString();
                struct.setKeywordIsSet(true);
            }
        }
    }

    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
}

