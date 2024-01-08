#include <stdio.h>

int main() {
    int n;
    printf("n = ");
    scanf("%d", &n);

    // Consume the newline character left in the input buffer
    getchar();

    char student[n];
    int score[n];

    for (int i = 0; i < n; i++) {
        printf("student is: ");
        scanf(" %c", &student[i]); // Add a space before %c

        printf("score = ");
        scanf("%d", &score[i]);
    }

    for (int i = 0; i < n; i++) {
        if (score[i] < 50) {
            printf("student: %c, score: %d\n", student[i], score[i]);
        }
    }

    return 0;
}
