DROP TABLE IF EXISTS custom_objects;
DROP TABLE IF EXISTS col_defn;







CREATE TABLE custom_objects (
                                site_id INT  ,
                                name VARCHAR(250) NOT NULL,
                                api_path VARCHAR(250) NOT NULL,
                                col_id VARCHAR(250) NOT NULL,
                                PRIMARY KEY(site_id, name)

);

CREATE TABLE col_defn (
                          id INT AUTO_INCREMENT,
                          col_id VARCHAR(250),
                          col_name VARCHAR (250) ,
                          col_type VARCHAR (250),
                          col_length INT ,
                          is_relation BOOL,
                          relation_name VARCHAR,
                          PRIMARY KEY(id, col_id),
                          FOREIGN KEY (col_id) REFERENCES custom_objects(col_id)
);
