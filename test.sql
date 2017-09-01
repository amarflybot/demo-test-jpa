select * from person;

SELECT * from address;

SELECT * FROM  person_address;


-- Find the person with 2 addresses.
select * from person INNER JOIN
  (select count(*) as ad_count, pid from person_address GROUP BY pid ) as pr_add
  on pr_add.pid = person.pid and pr_add.ad_count = 2;

-- Find the person with no addresses.
SELECT * from person LEFT JOIN person_address on person.pid = person_address.pid
  WHERE person_address.pid IS NULL ;

-- Find the person with matching first name and last name
SELECT p1.first_name, p1.last_name from person p1 JOIN person p2
    on p1.first_name = p2.last_name and p1.last_name = p2.first_name;

-- Second max salary
SELECT * from person WHERE salary in (select MAX(salary)
    from person WHERE salary NOT IN (SELECT MAX(salary) FROM person));