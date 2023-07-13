import * as Yup from "yup";

export const vacancySchema = Yup.object({
  id: Yup.number(),
  status: Yup.number(),
  // Job Description
  title: Yup.string().required("Job Title is required"),
  desiredDate: Yup.date().required("Desired filled date is required"),
  reportsTo: Yup.string().required("Reports to is required"),
  subordinates: Yup.string().required("Subordinates is required"),
  workingTime: Yup.string().required("Working time is required"),
  workingLocation: Yup.string().required("Working location is required"),
  industry: Yup.string().required("Industry is required"),
  yearsOfExperience: Yup.string().required("Years of Experiences is required"),
  jobLevel: Yup.string().required("Job level is required"),
  jobPosition: Yup.string().required("Job position is required"),
  startSalary: Yup.number()
    // .transform((_value, originalValue) =>
    //   Number(originalValue.replace(/,/g, ""))
    // )
    // .typeError("Amount must be a number")
    // .required("Minimum salary is required")
    .min(1, "Amount can't be negative")
    .max(9999999999, "Amount is too large"),
  endSalary: Yup.number()
    // .transform((_value, originalValue) =>
    //   Number(originalValue.replace(/,/g, ""))
    // )
    // .typeError("Amount must be a number")
    // .required("Maximum salary is required")
    .min(1, "Amount can't be negative")
    .max(9999999999, "Amount is too large")
    .moreThan(
      Yup.ref("startSalary"),
      "Maximum salary can't be lower than minimum salary"
    ),
  keyResponsibility: Yup.string().required("Key responsibility areas are required"),
  behaviouralCompetencies: Yup.string().required("Behavioural Competencies areas are required"),
  organizationCulture: Yup.string().required("Organizational culture are required"),
  // Additional Information
  targetedCompanies: Yup.string(),
  untargetedCompanies: Yup.string(),
  salaryReview: Yup.string(),
  bonusSystem: Yup.string(),
  benefits: Yup.string(),
});
