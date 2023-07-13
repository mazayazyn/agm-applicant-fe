import {
  Button,
  NumberInput,
  Select,
  Textarea,
  TextInput,
} from "@mantine/core";
import { DatePicker } from "@mantine/dates";
import { useForm, yupResolver } from "@mantine/form";
import { tempOptions } from "./TempOptions";
import { vacancySchema } from "./VacancySchema";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";

export function VacancyForm({ onEdit, id }) {
  const form = useForm({
    schema: yupResolver(vacancySchema),
    initialValues: {
      title: "",
      desiredDate: "",
      reportsTo: "",
      subordinates: "",
      workingTime: "",
      workingLocation: "",
      industry: "",
      yearsOfExperience: "",
      jobLevel: "",
      jobPosition: "",
      startSalary: 0,
      endSalary: 0,
      keyResponsibility: "",
      behaviouralCompetencies: "",
      organizationCulture: "",
      targetedCompanies: "",
      untargetedCompanies: "",
      salaryReview: "",
      bonusSystem: "",
      benefits: "",
    },
  });

  let navigate = useNavigate();

  const handleSubmit = async (data) => {
    console.log(data)
    if (onEdit) {
      await axios
      .put("/api/v1/admin/update-vacancy", data)
      .then((res) => {
        console.log(res.data.message);
      })
      .catch((err) => {
        console.log(err.response);
      });
      resetForm()
    } else {
      await axios
      .post("/api/v1/client/create-vacancy", data)
      .then((res) => {
        console.log(res.data.message);
      })
      .catch((err) => {
        console.log(err.response);
      });
      navigate("/u/dashboard");
    }
  };

  const resetForm = async () => {
    await axios
      .get(`/api/v1/admin/get-vacancy/${id}`)
      .then((res) => {
        res.data.desiredDate = new Date(res.data.desiredDate)
        form.setValues(res.data)
        // console.log(res.data);
      })
      .catch((err) => {
        console.log(err.response);
        if (err.response.status == 404) {
          navigate("/404");
        }
      });
  };

  useEffect(() => {
    if (onEdit) {
      resetForm();
    }
  }, []);

  return (
    <div className="container mx-auto max-w-screen-xl">
      <div className="flex flex-col mx-2 shadow-lg rounded my-10 border border-gray-200">
        <form onSubmit={form.onSubmit((values) => handleSubmit(values))}>
          <div className="flex flex-col md:flex-row p-5 rounded-t border-b border-gray-200">
            <div className="flex flex-col w-96 pb-5 mr-5">
              <p className="text-xl font-bold">Job Description</p>
              <p className="text-sm text-gray-400">
                Some of the information will be availables to the public.
              </p>
            </div>
            <div className="grid grid-cols-12 gap-10 w-full">
              <TextInput
                className={`md:col-span-6 col-span-12`}
                required
                label="Job Title"
                placeholder="IT Manager"
                {...form.getInputProps("title")}
              />
              <DatePicker
                className={`md:col-span-6 col-span-12`}
                required
                label="Closing Date"
                placeholder="Pick date"
                dropdownType="modal"
                minDate={new Date()}
                {...form.getInputProps("desiredDate")}
              />
              <TextInput
                className={`md:col-span-6 col-span-12`}
                required
                label="Reports to"
                placeholder="Reports to"
                {...form.getInputProps("reportsTo")}
              />
              <TextInput
                className={`md:col-span-6 col-span-12`}
                required
                label="Subordinates"
                placeholder="Subordinates"
                {...form.getInputProps("subordinates")}
              />
              <TextInput
                className={`md:col-span-6 col-span-12`}
                required
                label="Working Time"
                placeholder="Normal working hours"
                {...form.getInputProps("workingTime")}
              />
              <TextInput
                className={`md:col-span-6 col-span-12`}
                required
                label="Working Location"
                placeholder="Jakarta"
                {...form.getInputProps("workingLocation")}
              />
              <Select
                className={`md:col-span-6 col-span-12`}
                label="Industry"
                placeholder="Pick one"
                required
                searchable
                nothingFound="No options"
                data={tempOptions}
                {...form.getInputProps("industry")}
              />
              <Select
                className={`md:col-span-6 col-span-12`}
                label="Years of Experiences"
                placeholder="Pick one"
                required
                searchable
                nothingFound="No options"
                data={tempOptions}
                {...form.getInputProps("yearsOfExperience")}
              />
              <Select
                className={`md:col-span-6 col-span-12`}
                label="Job Level"
                placeholder="Pick one"
                required
                searchable
                nothingFound="No options"
                data={tempOptions}
                {...form.getInputProps("jobLevel")}
              />
              <Select
                className={`md:col-span-6 col-span-12`}
                label="Job Position"
                placeholder="Pick one"
                required
                searchable
                nothingFound="No options"
                data={tempOptions}
                {...form.getInputProps("jobPosition")}
              />
              <NumberInput
                className={`md:col-span-6 col-span-12`}
                required
                label="Minimum Salary"
                parser={(value) => value.replace(/\Rp\s?|(,*)/g, "")}
                formatter={(value) =>
                  !Number.isNaN(parseFloat(value))
                    ? `Rp ${value}`.replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                    : "Rp "
                }
                {...form.getInputProps("startSalary")}
              />
              <NumberInput
                className={`md:col-span-6 col-span-12`}
                required
                label="Maximum Salary"
                parser={(value) => value.replace(/\Rp\s?|(,*)/g, "")}
                formatter={(value) =>
                  !Number.isNaN(parseFloat(value))
                    ? `Rp ${value}`.replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                    : "Rp "
                }
                {...form.getInputProps("endSalary")}
              />
              <Textarea
                className={`col-span-12`}
                required
                label="Key Responsibility Areas"
                placeholder="Strategic Management"
                maxRows={2}
                {...form.getInputProps("keyResponsibility")}
              />
              <Textarea
                className={`col-span-12`}
                required
                label="Behavioural Competencies"
                placeholder="Organizing"
                maxRows={2}
                {...form.getInputProps("behaviouralCompetencies")}
              />
              <Textarea
                className={`col-span-12`}
                required
                label="Organizational Cultures"
                placeholder="Innovative"
                maxRows={2}
                {...form.getInputProps("organizationCulture")}
              />
            </div>
          </div>
          <div className="flex p-5 flex-col md:flex-row">
            <div className="flex flex-col w-96 pb-5 mr-5">
              <p className="text-xl font-bold">Additional Information</p>
              <p className="text-sm text-gray-400">
              Please provide any additional informations.
              </p>
            </div>
            <div className="grid grid-cols-12 gap-10 w-full">
              <Textarea
                className={`col-span-12`}
                label="1. Is there anyone working for your competitors that you would like us to approach? If yes, which companies?"
                maxRows={2}
                {...form.getInputProps("targetedCompanies")}
              />
              <Textarea
                className={`col-span-12`}
                label="2. Any companies you don't want candidate from?"
                maxRows={2}
                {...form.getInputProps("untargetedCompanies")}
              />
              <Textarea
                className={`col-span-12`}
                label="3. When is the first salary review?"
                maxRows={2}
                {...form.getInputProps("salaryReview")}
              />
              <Textarea
                className={`col-span-12`}
                label="4. Is there a bonus system? If yes, how is it calculated?"
                maxRows={2}
                {...form.getInputProps("bonusSystem")}
              />
              <Textarea
                className={`col-span-12`}
                label="5. What employee benefits are available for this position? Provide details as necessary (e.g. Overtime, Tax Allowance, Insurances, Stock, Incentives)"
                maxRows={2}
                {...form.getInputProps("benefits")}
              />
            </div>
          </div>
          <div className="flex p-3 rounded-b bg-gray-100 justify-end gap-x-2 outline outline-1 outline-gray-100">
            <Button variant="outline" onClick={() => navigate(-1)}>
              Cancel
            </Button>
            <Button type="submit">Submit</Button>
          </div>
        </form>
      </div>
    </div>
  );
}
