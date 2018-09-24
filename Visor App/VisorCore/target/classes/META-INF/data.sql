INSERT INTO students (nombre,apellidos,tiu,password,puntos,role) VALUES ('Diego','Alosilla','admin','123',10,'ROLE_ADMIN');
INSERT INTO students (nombre,apellidos,tiu,password,puntos,role) VALUES ('Juan','Lajo','u201611283','123',10,'ROLE_USER');
INSERT INTO students (nombre,apellidos,tiu,password,puntos,role) VALUES ('Roxana','Chavez','u201711283','123',10,'ROLE_USER');

INSERT INTO careers(career)	VALUES ('Ingeniria de Software');
INSERT INTO careers(career)	VALUES ('Ingeniria de Sistemas');
INSERT INTO careers(career)	VALUES ('Ciencias de la Computacion');

INSERT INTO courses(course) VALUES ('Open Source');

INSERT INTO courses_careers(course_id, careers_id) VALUES (1, 1);
INSERT INTO courses_careers(course_id, careers_id) VALUES (1, 2);
INSERT INTO courses_careers(course_id, careers_id) VALUES (1, 3);

