drop table if exists patients;
drop table if exists vaccines;

-- Create vaccines table
CREATE TABLE vaccines (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL,
    doses_required INT,
	days_between_doses INT,
	doses_received INT,
	doses_left INT
);

-- Create patients table
CREATE TABLE patients (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    vaccine_id INT,
    FOREIGN KEY (vaccine_id) REFERENCES vaccines(id),
    first_dose_date date,
	second_dose_date date
);

-- Insert initial data into vaccines table
insert into vaccines values (1, 'Pfizer/BioNTech', 2, 21, 10000, 1000);
insert into vaccines values (2, 'Johnson & Johnson', 1, null, 5000, 5000);
insert into vaccines values (3, 'Moderna', 2, 28, 10000, 10000);

-- Insert initial data into patients table
insert into patients values (1, 'John Doe', 1, '2021-02-18', '2021-03-11');
insert into patients values (2, 'Jane Doe', 1, '2021-02-18', null);
insert into patients values (3, 'Tom Smith', 2, '2021-03-12', null);

update vaccines v
join (
  select vaccine_id, count(first_dose_date) + count(second_dose_date) as count
  from patients
  where first_dose_date is not null or second_dose_date is not null
  group by vaccine_id
) p on v.id = p.vaccine_id
set v.doses_left = v.doses_left - count;