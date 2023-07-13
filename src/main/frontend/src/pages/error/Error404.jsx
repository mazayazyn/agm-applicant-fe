import { Landing } from "@/components/Landing/Index";
import { Button } from "@mantine/core";
import { useNavigate } from "react-router-dom";

export function Error404() {
  let navigate = useNavigate();

  return (
    <Landing>
      <div class="flex items-center justify-center h-fit pt-44">
        <div class="px-40 py-20 bg-white rounded-md shadow-xl">
          <div class="flex flex-col items-center">
            <h1 class="font-bold text-blue-600 text-9xl">404</h1>

            <h3 class="mb-2 text-2xl font-bold text-center text-gray-800 md:text-3xl">
              <span class="text-red-500">Oops!</span> Page not found
            </h3>

            <p class="mb-8 text-center text-gray-500 md:text-lg">
              The page you’re looking for doesn’t exist.
            </p>

            <Button
              onClick={() => navigate("/")}
            >
              Go home
            </Button>
          </div>
        </div>
      </div>
    </Landing>
  );
}