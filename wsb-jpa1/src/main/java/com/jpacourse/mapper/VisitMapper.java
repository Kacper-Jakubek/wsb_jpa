package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;

import java.util.ArrayList;
import java.util.List;
import com.jpacourse.persistance.entity.VisitEntity;

public class VisitMapper {

    public static List<VisitTO> mapListToTO(final List<VisitEntity> visitEntities)
    {
        List<VisitTO> list = new ArrayList<>();
        return list;
    }

    public static List<VisitEntity> mapListToEntity(final List<VisitTO> visitEntities)
    {
        List<VisitEntity> list = new ArrayList<>();
        return list;
    }
}
