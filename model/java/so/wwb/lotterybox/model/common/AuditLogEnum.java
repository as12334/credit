package so.wwb.lotterybox.model.common;

import org.soul.commons.enums.ICodeEnum;

/**
 * @author jeremy
 * @time 2018年09月13日21:34:21
 */
public enum AuditLogEnum implements ICodeEnum {

//    //账号相关
    UPDATE_PLAYER_ACCOUNT_PASSWORD("update.player.account.password", "[玩家账号-重置登录密码] 账号[{0}]");
//    UPDATE_PLAYER_ACCOUNT_PERMISSION_PASSWORD("update.player.account.permission_password", "[玩家账号-重置资金密码] 账号[{0}]"),
//    UPDATE_PLAYER_ACCOUNT_REAL_NAME("update.player.account.real_name", "[玩家账号-修改真实姓名] 账号[{0}] 真实姓名[{1}]"),
//    UPDATE_PLAYER_ACCOUNT_NICK_NAME("update.player.account.nick_name", "[玩家账号-修改昵称] 账号[{0}] 昵称[{1}]"),
//    UPDATE_PLAYER_ACCOUNT_MEMO("update.player.account.memo", "[玩家账号-修改备注] 账号[{0}] 备注[{1}]"),
//    UPDATE_PLAYER_ACCOUNT_INFO("update.player.account.info", "[玩家账号-修改详细资料] 账号[{0}]"),
//    UPDATE_PLAYER_ACCOUNT_STATUS("update.player.account.status", "[玩家账号-修改账号状态] 状态[{0}] 账号[{1}]"),
//    UPDATE_PLAYER_ACCOUNT_RANK("update.player.account.rank", "[玩家账号-修改所属层级] 层级[{0}] 账号[{1}]"),
//    UPDATE_PLAYER_ACCOUNT_RAKEBACK("update.player.account.rakeback", "[玩家账号-修改所属返水方案] 返水方案[{0}] 账号[{1}]"),
//    INSERT_PLAYER_BANK_CARD("insert.player.bank.card", "[玩家账号-新增银行卡] 账号[{0}] 银行[{1}] 卡号[{2}] 类型[{3}]"),
//    DELETE_PLAYER_BANK_CARD("delete.player.bank.card", "[玩家账号-删除银行卡] 账号[{0}] 银行[{1}] 卡号[{2}] 类型[{3}]"),
//    INSERT_PLAYER_ACCOUNT("insert.player.account", "[新增玩家/代理账号] 账号[{0}] 真实姓名[{1}] 类型[{2}] 层数[{3}] 上级代理[{4}]"),
//
//    //带玩相关
//    INSERT_TAKE_PLAY_ACCOUNT("insert.take.play.account", "[带玩账号-新增账号] 账号[{0}]"),
//    UPDATE_TAKE_PLAY_ACCOUNT_BALANCE("update.take.play.account.balance", "[带玩账号-修改钱包余额] 站点[{0}] 账号[{1}] 改前余额[{2}] 改后余额[{3}]"),
//    UPDATE_TAKE_PLAY_SYS_PARAM("update.take.play.sys.param", "[带玩账号-修改带玩系统参数] 站点[{0}] 改前注册次数上限[{1}] 改后注册次数上限[{2}] 改前注册初始金额[{3}] 改后注册初始金额[{4}]"),
//    UPDATE_TAKE_PLAY_ACCOUNT_STATUS("update.take.play.account.status", "[带玩账号-修改账号状态] 站点[{0}] 账号[{1}] 状态[{2}]"),
//
//    //平台账号
//    UPDATE_MANAGE_ACCOUNT_PASSWORD("update.manage.account.password", "[平台账号-重置登录密码] 站点[{0}] 账号[{1}] 类型[{2}] 上级[{3}] 状态[{4}]"),
//    UPDATE_MANAGE_ACCOUNT_STATUS("update.manage.account.status", "[平台账号-修改账号状态] 站点[{0}] 账号[{1}] 类型[{2}] 上级[{3}] 状态[{4}]"),
//    UPDATE_MANAGE_ACCOUNT_INFO("update.manage.account.info", "[平台账号-修改详细资料] 站点[{0}] 账号[{1}] 类型[{2}] 上级[{3}] 状态[{4}]"),
//    INSERT_MANAGE_ACCOUNT("insert.manage.account", "[平台账号-新增账号] 站点[{0}] 账号[{1}] 类型[{2}] 上级[{3}]"),
//    UPDATE_MANAGE_ACCOUNT_AUTHENTICATION_KEY("update.manage.account.authentication", "[平台账号-重置身份验证] 站点[{0}] 账号[{1}] 类型[{2}] 上级id[{3}] 验证码地址[{4}]"),
//
//
//    //资金
//    INSERT_MANUAL_DEPOSIT_ORDER("insert.manual.deposit.order", "[系统存款订单生成成功] 站点[{0}] [{1}]"),
//    INSERT_MANUAL_WITHDRAW_ORDER("insert.manual.withdraw.order", "[系统取款订单生成成功] 站点[{0}] 玩家[{1}] 订单号[{2}] 取款金额[{3}] 取款类型[{4}] 是否清楚稽核点[{5}]");






    private String code;
    private String trans;


    AuditLogEnum(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTrans() {
        return trans;
    }

}