package io.mycat.mpp;

import com.alibaba.fastsql.sql.ast.SQLObject;
import com.alibaba.fastsql.sql.ast.expr.SQLExprUtils;
import io.mycat.mpp.plan.DataAccessor;
import io.mycat.mpp.plan.RowType;
import io.mycat.mpp.runtime.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IntExpr implements SqlValue {
    final int value;

    public static IntExpr of(int value) {
        return new IntExpr(value);
    }

    @Override
    public Object getValue(RowType type, DataAccessor dataAccessor, DataContext context) {
        return value;
    }

    @Override
    public boolean getValueAsBoolean(RowType columns, DataAccessor dataAccessor, DataContext dataContext) {
        return false;
    }

    @Override
    public Type getType() {
        return Type.of(Type.INT,false);
    }

    @Override
    public SQLObject toParseTree() {
        return SQLExprUtils.fromJavaObject(value);
    }
}