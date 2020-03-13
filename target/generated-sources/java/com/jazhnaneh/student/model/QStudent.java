package com.jazhnaneh.student.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = -1406065471L;

    public static final QStudent student = new QStudent("student");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final StringPath family = createString("family");

    public final NumberPath<Long> idStudent = createNumber("idStudent", Long.class);

    public final ArrayPath<byte[], Byte> image = createArray("image", byte[].class);

    public final StringPath imageName = createString("imageName");

    public final StringPath imageType = createString("imageType");

    public final ListPath<Lesson, QLesson> lessons = this.<Lesson, QLesson>createList("lessons", Lesson.class, QLesson.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath nationalCode = createString("nationalCode");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QStudent(String variable) {
        super(Student.class, forVariable(variable));
    }

    public QStudent(Path<? extends Student> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudent(PathMetadata metadata) {
        super(Student.class, metadata);
    }

}

