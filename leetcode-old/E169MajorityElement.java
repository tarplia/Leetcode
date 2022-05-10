public class E169MajorityElement {
    static class CountElement {
        private int[] listEl;
        private int size;

        public CountElement(int[] nums) {
            size = 0;
            listEl = new int[nums.length/2];
        }

        private boolean isElementInTheList(int x) {
            for (int i = 0; i < size; i++) {
                if (listEl[i] == x) {
                    return true;
                }
            }
            return false;
        }

        private void addToList(int num) {
            listEl[size] = num;
            size++;
        }

        private void createList(int[] nums) {
            int index = 0;

            for (int i = 0; i < nums.length; i++) {
                if(!this.isElementInTheList(nums[i])) {
                    addToList(nums[i]);
                }
            }
        }

        public int countElementInList(int x, int[] nums) {
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == x) {
                    count++;
                }
            }

            return count;
        }

        public int majority() {
            int majorityEl = countEl[countEl.length-1]/2;

            for (int i = (countEl.length-1)/2 + 1; i < countEl.length; i++) {
                if (countEl[i] != -53)
                    majorityEl = countEl[i];
            }
            return majorityEl;
        }
    }

    public int majorityElement(int[] nums) {
        CountElement arrayEl = new CountElement(nums);

        int[] elementList = arrayEl.getElementList(nums);
        int counting = 0;

        for (int i = 0; i < elementList.length; i++) {
            counting = arrayEl.countElementInList(elementList[i], nums);
            arrayEl.placeElementInCountList(counting, elementList[i]);
        }

        return arrayEl.majority();
    }

    public static void main(String[] args) {
        E169MajorityElement program = new E169MajorityElement();

        //int[] nums = new int[] {-1,1,1,1,2,1};

        //CountElement arrayEl = new CountElement(nums);

        //System.out.println(arrayEl.countElementInList(2, nums));


        System.out.println(program.majorityElement(new int[]{1,1,1,1,1,1,8}));
        //System.out.println(program.majorityElement(new int[]{2,2,1,3,3,3,3,3,3,3,3,1,1,2,2}));

    }
}
