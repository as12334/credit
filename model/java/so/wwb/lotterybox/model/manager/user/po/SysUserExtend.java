package so.wwb.lotterybox.model.manager.user.po;

import org.soul.commons.support.Nonpersistent;
import org.soul.model.security.privilege.po.SysUser;

/**
 * 用户扩展表实体
 * 该表继承sys_user
 * Create by fei on 2018-01-14
 */
public class SysUserExtend extends SysUser {

    private static final long serialVersionUID = 4212061721572381108L;

    public static final String PROP_CODE = "code";
    public static final String PROP_OWNER_CODE = "ownerCode";
    public static final String PROP_OWNER_NAME = "ownerName";
    public static final String PROP_PARENT_IDS = "parentIds";
    public static final String PROP_PARENT_NAMES = "parentNames";
    public static final String PROP_KEY = "key";
    public static final String PROP_UPDATE_NAME="updateName";

    /** 代号 */
    private String code;
    /** 上层代号 */
    private String ownerCode;
    /** 上层名称 */
    private String ownerName;
    /** 上级ids，层层递进，以逗号分割 */
    private String parentIds;
    /** 上级账号，层层递进，以逗号分割 */
    private String parentNames;
    /** 钥匙 */
    private String key;
    /** 修改人名称 */
    private  String  updateName;
    /** 上级信息 */
//    private VUserPlayer parent;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getParentNames() {
        return parentNames;
    }

    public void setParentNames(String parentNames) {
        this.parentNames = parentNames;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    // region 非表属性

    public static final String PROP_CODE_OWNER = "codeOwner";

    private String nameInfo;
    private String hallUri;
    private String payUri;

    private String codeOwner;

    @Nonpersistent
    public String getNameInfo() {
        return this.nameInfo;
    }
    public void setNameInfo(String nameInfo) {
        this.nameInfo = nameInfo;
    }

    @Nonpersistent
    public String getHallUri() {
        return hallUri;
    }
    public void setHallUri(String hallUri) {
        this.hallUri = hallUri;
    }

    @Nonpersistent
    public String getPayUri() {
        return payUri;
    }
    public void setPayUri(String payUri) {
        this.payUri = payUri;
    }

    @Nonpersistent
    public String getCodeOwner() {
        return (this.ownerCode == null ? "" : this.ownerCode.toUpperCase()) + ":" + (this.code == null ? "" : this.code.toUpperCase());
    }

//    public VUserPlayer getParent() {
//        return parent;
//    }
//
//    public void setParent(VUserPlayer parent) {
//        this.parent = parent;
//    }


    // endregion

}