package com.asm.hibernate.intercept;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.asm.hibernate.domain.User;

public class AutoUpdateTimeInterceptor extends EmptyInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7749545854963135072L;
	@Override
    public boolean onSave(Object entity, Serializable id, Object[] state,
            String[] propertyNames, Type[] types)
    {    
        if (entity instanceof User)
        {
            for (int index=0;index<propertyNames.length;index++)
            {
                /*�ҵ���Ϊ"checkinTime"������*/
                if ("date".equals(propertyNames[index]))
                {
                    /*ʹ����������user �����"date"���Ը���ֵ*/
                    state[index] = new Date(113,11,18);
                    return true;
                }
            }
        }

        return false;
    }



}
