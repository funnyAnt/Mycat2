/**
 * Copyright (C) <2020>  <chen junwen>
 * <p>
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along with this program.  If
 * not, see <http://www.gnu.org/licenses/>.
 */
package io.mycat.hbt3;

import io.mycat.DataNode;

import java.util.List;

public abstract class Distribution {

    public abstract List<DataNode> getDataNodes();


    public abstract String digest();

    public
    abstract boolean isSingle();

    public abstract boolean isBroadCast();

    public abstract boolean isSharding();

    public abstract boolean isJoin();

    public static Distribution of(List<DataNode> dataNodeList, String digest, DistributionImpl.Type type) {
        return new DistributionImpl(dataNodeList, digest, type);
    }

    abstract public Type type();

    public abstract boolean isPhy();

    public static enum Type {
        PHY,
        BroadCast,
        Sharding,
        JOIN
    }

}