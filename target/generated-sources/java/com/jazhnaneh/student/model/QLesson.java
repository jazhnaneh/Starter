package com.jazhnaneh.student.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLesson is a Querydsl query type for Lesson
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLesson extends EntityPathBase<Lesson> {

    private static final long serialVersionUID = 1264361970L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLesson lesson = new QLesson("lesson");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final NumberPath<Long> lessonId = createNumber("lessonId", Long.class);

    public final QStudent student;

    public final StringPath title = createString("title");

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QLesson(String variable) {
        this(Lesson.class, forVariable(variable), INITS);
    }

    public QLesson(Path<? extends Lesson> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLesson(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLesson(PathMetadata metadata, PathInits inits) {
        this(Lesson.class, metadata, inits);
    }

    public QLesson(Class<? extends Lesson> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student")) : null;
    }

}

